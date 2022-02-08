package eu.example.loginapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.text.InputType
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.password_toggle)
        val loginbutton = findViewById<MaterialButton>(R.id.loginbtn)
        val showpass=findViewById<CheckBox>(R.id.ShowPass)
        var timesclicked= 5
        fun textlogin()
        {
            setContentView(R.layout.login_activity)
            val textview=findViewById<TextView>(R.id.hi)
            textview.text="hi, welcome"

        }
        showpass.setOnClickListener {
            if (showpass.isChecked) {
                pass.inputType = 1
            } else {
                pass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
        loginbutton.setOnClickListener {
            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService.vibrate(3)
            if(name.getText().toString().equals("") && pass.getText().toString().equals("")){
                Toast.makeText(this@MainActivity, "enter and try again", Toast.LENGTH_SHORT).show()
            }

            else if (name.getText().toString().equals("admin") && pass.getText().toString().equals("admin")
            ) {
                Toast.makeText(this@MainActivity, "login successful", Toast.LENGTH_SHORT).show()
                textlogin()
            } else {
                timesclicked -= 1

                if(timesclicked>0)
                {
                    Toast.makeText(this@MainActivity, "unsucessful login", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this@MainActivity, timesclicked.toString()+" Attempts left", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this@MainActivity, "too many login attempt", Toast.LENGTH_SHORT).show()
                    System.exit(0)
                }


            }



        }
    }
}

