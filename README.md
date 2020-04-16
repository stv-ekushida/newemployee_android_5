# newemployee_android_5
リストビューとダイアログ

## リストビュー
### ArrayAdapterを利用した例

```
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
```


## ダイアログ

### ダイアログの表示

```
val dialogFragment = OrderConfirmDialogFragment()
dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragmentd")
```

### ダイアログの作成
```
class OrderConfirmDialogFragment : DialogFragment() {

    override fun onCreateDialog(saveInstanceState: Bundle?) : Dialog {

        //ダイアログビルダーの生成
        val builder = AlertDialog.Builder(activity)

        builder.setTitle(R.string.dialog_title)
        builder.setMessage(R.string.dialog_msg)

        builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
        builder.setNegativeButton(R.string.dialog_btn_ok, DialogButtonClickListener())
        builder.setNeutralButton(R.string.dialog_btn_ok, DialogButtonClickListener())

        val dialog = builder.create()
        return dialog
    }

    private inner class DialogButtonClickListener: DialogInterface.OnClickListener {

        override fun onClick(dialog: DialogInterface?, which: Int) {

            var msg = ""

            when(which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    msg = getString(R.string.dialog_ok_toast)
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                    msg = getString(R.string.dialog_ng_toast)
                }
                DialogInterface.BUTTON_NEUTRAL -> {
                    msg = getString(R.string.dialog_nu_toast)
                }
            }
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}
```
