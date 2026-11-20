package com.example.kartkowka20listopada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected static ArrayList<Integer> imageViewsArray;
    private Button buttonWst, buttonDal, buttonPol, buttonZer;
    private int ktoreZdjecie, LicznikPol;
    private TextView textView;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonDal = findViewById(R.id.buttonDal);
        buttonPol = findViewById(R.id.buttonPol);
        buttonWst = findViewById(R.id.buttonWst);
        buttonZer = findViewById(R.id.buttonZer);
        imageView2 = findViewById(R.id.imageView);
        textView = findViewById(R.id.Tekst);
        View widok = findViewById(R.id.main);
        LicznikPol = 0;
        listaZdj();
        buttonDal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktoreZdjecie++;
                        if (ktoreZdjecie >= imageViewsArray.size()){
                            ktoreZdjecie = 0;
                        }
                        pokazZdj(ktoreZdjecie);
                    }
                }
        );
        buttonWst.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktoreZdjecie--;
                        if (ktoreZdjecie < imageViewsArray.size()){
                            ktoreZdjecie = 3;
                        }
                        pokazZdj(ktoreZdjecie);
                    }
                }
        );
        buttonPol.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LicznikPol ++;
                        textView.setText(LicznikPol+"");
                    }
                }
        );
        buttonZer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LicznikPol = 0;
                        textView.setText(LicznikPol+"");
                    }
                }
        );
        textView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView.setText(LicznikPol);
                        polubieniaIlosc(0);
                    }
                }
        );
    }
    private void listaZdj(){
        imageViewsArray = new ArrayList<Integer>();
        imageViewsArray.add(R.drawable.burza);
        imageViewsArray.add(R.drawable.gwiazda);
        imageViewsArray.add(R.drawable.stopka);
    }
    private void pokazZdj (int ktoreZdjecie){
        imageView2.setImageResource(imageViewsArray.get(ktoreZdjecie));
    }
    private void polubieniaIlosc(int licznikPol){
        textView.setText(LicznikPol);
    }
}