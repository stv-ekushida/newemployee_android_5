package jp.co.stv_tech.android_5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        val menuList = mutableListOf<String>("唐揚げ定食","ハンバーク定食","生姜焼き定食",
            "ステーキ定食","野菜炒め定食")

        //リストビューとリストデータを結びつけるアダプタークラス
        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_list_item_1,
            menuList)
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickLister()
    }

    private  inner class ListItemClickLister: AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, postion: Int, id: Long) {

            val dialogFragment = OrderConfirmDialogFragment()

            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragmentd")
        }
    }
}
