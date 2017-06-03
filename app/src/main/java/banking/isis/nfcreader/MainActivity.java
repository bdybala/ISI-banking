package banking.isis.nfcreader;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import nfctutorials.tutorial02.R;

public class MainActivity extends ActionBarActivity {

    NfcAdapter nfcAdapter;
    private boolean scanning = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (nfcAdapter == null ) {
            Toast.makeText(this, "NFC is not supported for this device", Toast.LENGTH_LONG).show();
        } else if (!nfcAdapter.isEnabled()){
            Toast.makeText(this, "NFC is not enabled", Toast.LENGTH_LONG).show();;
        }

    }

    @Override
    protected void onNewIntent(final Intent intent) {
        if(scanning){
            ((ViewGroup) ((ProgressBar) findViewById(R.id.progressBar)).getParent()).removeView(((ProgressBar) findViewById(R.id.progressBar)));
            ((LinearLayout)findViewById(R.id.scanningBar)).setVisibility(LinearLayout.VISIBLE);

            ((LinearLayout)findViewById(R.id.hajs)).setVisibility(LinearLayout.VISIBLE);
            EditText editText = ((EditText)findViewById(R.id.sumOfMoney));
            editText.addTextChangedListener(new NumberWatcher(editText,"#,###.##" ));
            ((Button)this.findViewById(R.id.button)).setVisibility(Button.VISIBLE);
            scanning = false;
        }
        Toast.makeText(this, "NFc intent received!", Toast.LENGTH_LONG).show();
        String action = intent.getAction();
        TextView textView = (TextView)this.findViewById(R.id.info);
        if(action.equals(NfcAdapter.ACTION_TAG_DISCOVERED)){
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (tag == null) {
                textView.setText("tag == null");
                Toast.makeText(this, "xcwe", Toast.LENGTH_LONG).show();
            } else {

                String tagInfo2 = "";

                byte[] tagId = tag.getId();

                for (int i = 0; i < tagId.length; i++) {

                    tagInfo2 += Integer.toHexString(tagId[i] & 0xFF);
                }
                tagInfo2 = "ID: " + Long.parseLong(tagInfo2, 16);
                textView.setGravity(Gravity.LEFT);
                textView.setText(tagInfo2);
                ((TextView)findViewById(R.id.carddetected)).setVisibility(TextView.VISIBLE);
        }

        }
        super.onNewIntent(intent);
    }


    protected void onResume() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, 0);
        IntentFilter[] intentFilter = new IntentFilter[] {};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter,
                null);

        super.onResume();
    }

    @Override
    protected void onPause() {

        nfcAdapter.disableForegroundDispatch(this);
        nfcAdapter.disableReaderMode(this);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            return rootView;
        }
    }
    private void sendPost(String id, String price) throws Exception {
        String urlParameters = "id=" + id + "&price=" + price;
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        String request = "http://93.180.188.108:8081/REST_project/rest/AccountService/login?";
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(postData);


        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0; )
            sb.append((char) c);
        String response = sb.toString();

        String id2 = getId(response);
    }

    static String getId(String msg) {
        String ret = null;
        DocumentBuilder newDocumentBuilder = null;
        try {
            newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(msg.getBytes()));
            ret = parse.getFirstChild().getFirstChild().getTextContent();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }


}


