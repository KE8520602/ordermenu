package com.example.ordermenu

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val name = intent.getStringExtra("nameKey") //使用getExtra參考key值
        tv_name.text = "訂購人姓名：$name"


        btn_send.setOnClickListener {  //點擊事件
            if (ed_orderdrink.length() < 1)
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            //設if條件，提醒一定要輸入飲料名稱


            else {

                val sugar =
                    RadioGroup_sugar.findViewById<RadioButton>(RadioGroup_sugar.checkedRadioButtonId).text
                val ice =
                    RadioGroup_ice.findViewById<RadioButton>(RadioGroup_ice.checkedRadioButtonId).text
                val bundle = Bundle()
                bundle.putString("drinksKey", ed_orderdrink.text.toString())
                bundle.putString("iceKey", ice.toString()) //putString("Key", value)
                bundle.putString("sugarKey", sugar.toString()) //putString("Key", value)
                val intent = Intent()
                intent.putExtras(bundle)

                setResult(Activity.RESULT_OK, intent) //main1.starActivtiyForResult->main2.setResult->main1.onActivityResult
                finish()

            }
        }


    }

    override fun onCreateOptionsMenu(menu_main: Menu?): Boolean {
        //設置做為選單的menu
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu_main)
        //指定R.menu.名稱
        return super.onCreateOptionsMenu(menu_main)
    }










}