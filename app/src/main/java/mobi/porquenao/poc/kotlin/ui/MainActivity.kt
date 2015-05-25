package mobi.porquenao.poc.kotlin.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import butterknife.bindView
import mobi.porquenao.poc.kotlin.R

public class MainActivity : BaseActivity() {

    private var mAdapter: MainAdapter? = null

    val vList: RecyclerView by bindView(R.id.list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        vList.setHasFixedSize(true)
        vList.setLayoutManager(LinearLayoutManager(this))
        mAdapter = MainAdapter()
        vList.setAdapter(mAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        mAdapter!!.add()
        vList.smoothScrollToPosition(0)
        return true
    }

}
