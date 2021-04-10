package com.example.minorproject;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
EditText et0,et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20,et21,et22,et23,et24,et25;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et0=findViewById(R.id.mean_texture);
        et1=findViewById(R.id.mean_perimeter);
        et2=findViewById(R.id.mean_smoothness);
        et3=findViewById(R.id.mean_compactness);
        et4=findViewById(R.id.mean_concavity);
        et5=findViewById(R.id.mean_concavepoints);
        et6=findViewById(R.id.mean_symmetry);
        et7=findViewById(R.id.mean_fractaldimension);
        et8=findViewById(R.id.radius_error);
        et9=findViewById(R.id.texture_error);
        et10=findViewById(R.id.Perimeter_error);
        et11=findViewById(R.id.area_error);
        et12=findViewById(R.id.smoothness_error);
        et13=findViewById(R.id.compactness_error);
        et14=findViewById(R.id.concavity_error);
        et15=findViewById(R.id.concave_pointserror);
        et16=findViewById(R.id.symmetry_error);
        et17=findViewById(R.id.fractal_dimesnionerror);
        et18=findViewById(R.id.worst_radius);
        et19=findViewById(R.id.worst_texture);
        et20=findViewById(R.id.worst_smoothness);
        et21=findViewById(R.id.worst_compactness);
        et22=findViewById(R.id.worst_concavity);
        et23=findViewById(R.id.worst_concavepoints);
        et24=findViewById(R.id.worst_symmetry);
        et25=findViewById(R.id.worst_fractaldimesnion);
        bt=findViewById(R.id.submit);
        et0.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 39 )}) ;
        et1.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 130 )}) ;
        et2.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3 )}) ;
        et3.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3 )}) ;
        et4.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 4)}) ;
        et5.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 4)}) ;
        et6.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2)}) ;
        et7.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3 )}) ;
        et8.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3)}) ;
        et9.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 5 )}) ;
        et10.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 6)}) ;
        et11.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 75 )}) ;
        et12.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 4)}) ;
        et13.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2)}) ;
        et14.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3)}) ;
        et15.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 5)}) ;
        et16.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 6)}) ;
        et17.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2)}) ;
        et18.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 30)}) ;
        et19.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 50)}) ;
        et20.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 50)}) ;
        et21.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2)}) ;
        et22.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2)}) ;
        et23.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2)}) ;
        et24.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3)}) ;
        et25.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2 )}) ;

    }

    public void post(View view) {
        if(!(TextUtils.isEmpty(et0.getText().toString())) && !(TextUtils.isEmpty(et1.getText().toString()))&& !(TextUtils.isEmpty(et2.getText().toString()))&& !(TextUtils.isEmpty(et3.getText().toString()))&& !(TextUtils.isEmpty(et4.getText().toString()))&& !(TextUtils.isEmpty(et5.getText().toString()))&& !(TextUtils.isEmpty(et6.getText().toString()))&& !(TextUtils.isEmpty(et7.getText().toString()))&& !(TextUtils.isEmpty(et8.getText().toString()))&& !(TextUtils.isEmpty(et9.getText().toString()))&& !(TextUtils.isEmpty(et10.getText().toString()))&& !(TextUtils.isEmpty(et11.getText().toString()))&& !(TextUtils.isEmpty(et12.getText().toString()))&& !(TextUtils.isEmpty(et13.getText().toString()))&& !(TextUtils.isEmpty(et14.getText().toString()))&& !(TextUtils.isEmpty(et15.getText().toString()))&& !(TextUtils.isEmpty(et16.getText().toString()))&& !(TextUtils.isEmpty(et17.getText().toString()))&& !(TextUtils.isEmpty(et18.getText().toString()))&& !(TextUtils.isEmpty(et19.getText().toString()))&& !(TextUtils.isEmpty(et20.getText().toString()))&& !(TextUtils.isEmpty(et21.getText().toString()))&& !(TextUtils.isEmpty(et22.getText().toString()))&& !(TextUtils.isEmpty(et23.getText().toString()))&& !(TextUtils.isEmpty(et24.getText().toString()))&& !(TextUtils.isEmpty(et25.getText().toString())))
        {
            //using Volley for POST Method

            RequestQueue queue = Volley.newRequestQueue(this);
            final String url = "";
            JSONObject postparams = new JSONObject();
            try {
                // inserting post params into JSONObject
                postparams.put("meantexture",et0.getText().toString());
                postparams.put("meanperimeter",et1.getText().toString());
                postparams.put("meansmoothness",et2.getText().toString());
                postparams.put("meancompactness",et3.getText().toString());
                postparams.put("meanconcavity",et4.getText().toString());
                postparams.put("meanconcavepoints",et5.getText().toString());
                postparams.put("meansymmetry",et6.getText().toString());
                postparams.put("meanfractaldimension",et7.getText().toString());
                postparams.put("radiuserror",et8.getText().toString());
                postparams.put("textureerror",et9.getText().toString());
                postparams.put("perimetererror",et10.getText().toString());
                postparams.put("areaerror",et11.getText().toString());
                postparams.put("smoothnesserror",et12.getText().toString());
                postparams.put("compactnesserror",et13.getText().toString());
                postparams.put("conavityerror",et14.getText().toString());
                postparams.put("concavepointserror",et15.getText().toString());
                postparams.put("symmetryerror",et16.getText().toString());
                postparams.put("fractaldimensionerror",et17.getText().toString());
                postparams.put("worstradius",et18.getText().toString());
                postparams.put("worsttexture",et19.getText().toString());
                postparams.put("worstsmoothness",et20.getText().toString());
                postparams.put("worstcompactness",et21.getText().toString());
                postparams.put("worstconcavity",et22.getText().toString());
                postparams.put("worstconcavepoints",et23.getText().toString());
                postparams.put("worstsymmetry",et24.getText().toString());
                postparams.put("worstfractaldimension",et25.getText().toString());
                // insert all the remaining params into json object
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, postparams, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i("On Response", "onResponse: "+response.toString());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

                }
            });
            queue.add(jsonObjectRequest);

        }
        else{
            Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show();
        }
    }}
