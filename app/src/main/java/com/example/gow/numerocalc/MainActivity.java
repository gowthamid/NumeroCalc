package com.example.gow.numerocalc;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static EditText editText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

    }
    public void onClickEditTxt(View v)
    {
        editText.setText("");
    }
    public void onClickBtn(View v)
    {
        //Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        //Toast.makeText(this, editText.getText(), Toast.LENGTH_LONG).show();

        Map<Integer, List<String>> numerMap = new HashMap<>();

        List<String> alpha1=new ArrayList<String>();
        List<String> alpha2=new ArrayList<String>();
        List<String> alpha3=new ArrayList<String>();
        List<String> alpha4=new ArrayList<String>();
        List<String> alpha5=new ArrayList<String>();
        List<String> alpha6=new ArrayList<String>();
        List<String> alpha7=new ArrayList<String>();
        List<String> alpha8=new ArrayList<String>();

        alpha1.add("A");
        alpha1.add("I");
        alpha1.add("J");
        alpha1.add("Q");
        alpha1.add("Y");

        alpha2.add("B");
        alpha2.add("K");
        alpha2.add("R");

        alpha3.add("C");
        alpha3.add("G");
        alpha3.add("L");
        alpha3.add("S");

        alpha4.add("D");
        alpha4.add("M");
        alpha4.add("T");

        alpha5.add("E");
        alpha5.add("H");
        alpha5.add("N");
        alpha5.add("X");

        alpha6.add("U");
        alpha6.add("V");
        alpha6.add("W");

        alpha7.add("O");
        alpha7.add("Z");

        alpha8.add("F");
        alpha8.add("P");

        numerMap.put(1, alpha1);
        numerMap.put(2, alpha2);
        numerMap.put(3, alpha3);
        numerMap.put(4, alpha4);
        numerMap.put(5, alpha5);
        numerMap.put(6, alpha6);
        numerMap.put(7, alpha7);
        numerMap.put(8, alpha8);
        int sum = calculateNumero(numerMap,editText.getText().toString());
        //Toast.makeText(this, String.valueOf(sum), Toast.LENGTH_LONG).show();

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Why wait?! Register with the same serial");
        alertDialogBuilder.setMessage("If your lucky number is "+String.valueOf(sum));
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public static int calculateNumero(Map<Integer, List<String>> numerMap, String input)
    {
        int sum=0;
        int total=0;

        int key=0;
        List<String> value=null;

        String ipUpper=input.toUpperCase();
        char[] ipArr=ipUpper.toCharArray();

        for(char ip:ipArr){
            //System.out.println("ipArr "+ipArr.length);//for(int i=0;i<=input.length();i++){
            if(!Character.isDigit(ip))
                for (Map.Entry<Integer, List<String>> e : numerMap.entrySet()) {
                    key = e.getKey();
                    value = e.getValue();
                    if(value.contains(String.valueOf(ip)))  //"P"
                        sum=sum+key;//return key;
                    //System.out.println(key+" "+value);

                }
            else
                sum=sum+ip;
        }
        while (sum > 0) {
            total = total + sum % 10;
            sum = sum / 10;
        }
        return total;
    }
}
