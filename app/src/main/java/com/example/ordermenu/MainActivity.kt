package com.example.ordermenu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {

            val name = ed_name.text.toString()//讀ed_name的內容
            if (ed_name.text.toString().isBlank())
                Toast.makeText(this@MainActivity, "請輸入訂購人姓名", Toast.LENGTH_SHORT ).show()


            else {
                val intent = Intent(this, MainActivity2::class.java)
                //MainActivity.this可簡寫成this

                intent.putExtra("nameKey", name)

                startActivityForResult(intent, 1)
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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK)
                tv_others.text = "飲料:${it.getString("drinksKey")}\n\n甜度:${it.getString("sugarKey")}\n\n冰塊:${it.getString("iceKey")}"
        }
    }




}