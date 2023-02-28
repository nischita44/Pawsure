package com.appsnipp.education;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class PetRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_registration);
        Button reg = (Button) findViewById(R.id.button2);
        EditText pid = (EditText) findViewById(R.id.petId);
        EditText page = (EditText) findViewById(R.id.petAge) ;
        EditText pbreed = (EditText) findViewById(R.id.petBreed) ;
        EditText pmedical = (EditText) findViewById(R.id.petMedical) ;
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = pid.getText().toString();
                String age = page.getText().toString();
                String breed = pbreed.getText().toString();
                String medical = pmedical.getText().toString();
                reg.setBackgroundResource(R.drawable.login2);


                if (id.matches("") || age.matches("") || breed.matches("") || medical.matches("")) {
                    Toast.makeText(PetRegistrationActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;

                }
                else {
                    CustomDialog1 customDialog1 = new CustomDialog1();
                    customDialog1.showDialog(PetRegistrationActivity.this);

                }

            }

        });
    }

}
