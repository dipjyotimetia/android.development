package org.sayem.booklisting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> bookList = new ArrayList<String>();
    private ListView bookListView;
    private ArrayAdapter<String> arrayAdapter;
    private EditText searchField;
    private Button searchButton;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // http://code.hootsuite.com/orientation-changes-on-android/
        if (savedInstanceState != null)
            bookList = savedInstanceState.getStringArrayList("headerList");

        bookListView = (ListView) findViewById(R.id.bookListView);
        searchField = (EditText) findViewById(R.id.search_field);
        searchButton = (Button) findViewById(R.id.search_button);

        description = (TextView) findViewById(R.id.description);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bookList);
        bookListView.setAdapter(arrayAdapter);

        if (!bookList.isEmpty()) {
            description.setText("");
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookList.clear();
                String searchText = searchField.getText().toString();
                System.out.println("Search Text " + searchText);
                DownloadTask task = new DownloadTask();
                String urlEndPoint = "https://www.googleapis.com/books/v1/volumes?q=" + searchText + "&maxResults=20";
                urlEndPoint = urlEndPoint.replaceAll("\\s+", "");
                task.execute(urlEndPoint);
                searchField.setText(" ");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("headerList", bookList);
        super.onSaveInstanceState(outState);
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;

                    result += current;

                    data = reader.read();
                }

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String books = jsonObject.getString("items");

                    JSONArray arr = new JSONArray(books);

                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject jsonPart = arr.getJSONObject(i);

                        JSONObject volumeInfo = jsonPart.getJSONObject("volumeInfo");

                        String title = volumeInfo.getString("title");
                        String authors = "";
                        try {
                            JSONArray authorArr = volumeInfo.getJSONArray("authors");
                            for (int x = 0; x < authorArr.length(); x++) {
                                System.out.println(authorArr.get(x));
                                authors += authorArr.get(x) + "    ";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(title);

                        String book = title + " by " + authors;
                        bookList.add(book);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                bookListView.setAdapter(arrayAdapter);

                if (!bookList.isEmpty()) {
                    description.setText("");
                }
            } else {
                Toast.makeText(getApplicationContext(), "No results found.", Toast.LENGTH_LONG).show();
            }
        }
    }
}