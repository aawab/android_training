package org.coursera.sustainableapps.rssfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvRSS;
    ArrayList<String> titles;
    ArrayList<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvRSS = findViewById(R.id.lvRSS);

        titles = new ArrayList<String>();
        links = new ArrayList<String>();

        lvRSS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri url = Uri.parse(links.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW,url);
                startActivity(intent);
            }
        });
        new ProcessInBackground();
    }

    public InputStream getInputStream(URL url){
        try{
            return url.openConnection().getInputStream();
        }
        catch (IOException e){
            return null;
        }
    }

    public class ProcessInBackground extends AsyncTask<Integer,Void,Exception>{

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        Exception exception = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Busy loading rss feed..please wait..");
            progressDialog.show();
        }

        @Override
        protected Exception doInBackground(Integer... integers) {
            try{
                URL url = new URL("http://feeds.news24.com/articles/fin24/tech/rss");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);

                XmlPullParser parser = factory.newPullParser();
                parser.setInput(getInputStream(url),"UTF_8");

                boolean insideItem=false;

                int eventType = parser.getEventType();

                while(eventType!=XmlPullParser.END_DOCUMENT){
                    if(eventType==XmlPullParser.START_TAG){
                        if(parser.getName().equalsIgnoreCase("item")){
                            insideItem=true;
                        }
                        else if(parser.getName().equalsIgnoreCase("title")){
                            if(insideItem){
                                titles.add(parser.nextText());

                            }
                        }
                        else if(parser.getName().equalsIgnoreCase("link")){
                            if(insideItem){
                                links.add(parser.nextText());
                            }
                        }
                    }
                    else if(eventType==XmlPullParser.END_TAG && parser.getName().equalsIgnoreCase("item")){
                        insideItem=false;

                    }
                    eventType=parser.next();
                }
            }
            catch(MalformedURLException e){
                exception=e;
            }
            catch(XmlPullParserException e){
                exception=e;
            }
            catch(IOException e){
                exception=e;
            }
            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.
                    this,android.R.layout.simple_list_item_1,titles);

            lvRSS.setAdapter(adapter);
            progressDialog.dismiss();

        }
    }
}