package com.example.ths00000_layout;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class FifthActivity extends Activity {
	ArrayList<HashMap<String,String>> m_list
	 = new ArrayList<HashMap<String,String>>(); // データ
	SimpleAdapter m_adapter; // アダプタ
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifth);
		// データ準備
		HashMap<String, String> hash;
		
		hash = new HashMap<String, String>();
		hash.put("TEXT", "テキストです");
		hash.put("CHECK", "チェックです");
		m_list.add(hash);

		hash = new HashMap<String, String>();
		hash.put("TEXT", "テキストです2");
		hash.put("CHECK", "チェックです2");
		m_list.add(hash);
		
		// アダプタ準備
		m_adapter = new SimpleAdapter(
		  this, m_list, R.layout.listview_sub,
		  new String[]{"TEXT", "CHECK"},
		  new int[]{R.id.textView1, R.id.checkBox1});
		
		// アダプタ設定
		ListView listView = (ListView)
				findViewById(R.id.listView1);
		listView.setAdapter(m_adapter);
		// アイテムクリック時の処理
		listView.setOnItemClickListener(
		new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(
			  AdapterView<?> parent, View view,
			  int position, long id) {
				HashMap<String, String> hash = 
					m_list.get(position);
				String text = hash.get("TEXT"); 
				// Toast表示
				Toast.makeText(FifthActivity.this,
				  text, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	// リスト追加
	public void buttonMethodAdd(View button){
		// EditTextから入力値の取得
		EditText edit = (EditText)
				findViewById(R.id.editText1);
		String t = edit.getText().toString();
		
		// リストビューに項目追加
		HashMap<String, String> hash =
			new HashMap<String, String>();
		hash.put("TEXT", t);
		hash.put("CHECK", "test");
		m_list.add(hash);
		m_adapter.notifyDataSetChanged();
	}
	
	// リスト削除
	public void buttonMethodDelete(View button){
		m_list.remove(m_list.size() - 1);
		m_adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fifth, menu);
		return true;
	}

}
