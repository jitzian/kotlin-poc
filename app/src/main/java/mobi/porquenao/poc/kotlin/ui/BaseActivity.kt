package mobi.porquenao.poc.kotlin.ui

import android.app.ActivityManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import mobi.porquenao.poc.kotlin.R

public abstract class BaseActivity : AppCompatActivity() {

    val vToolbar: Toolbar? by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareTaskDescription()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        if (vToolbar != null) {
            setSupportActionBar(vToolbar)
        }
    }

    private fun prepareTaskDescription() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (sTaskDescription == null) {
                val label = getString(R.string.app_name)
                val icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_task)
                val colorPrimary = getResources().getColor(R.color.app_primary_500)
                sTaskDescription = ActivityManager.TaskDescription(label, icon, colorPrimary)
            }
            setTaskDescription(sTaskDescription)
        }
    }

    companion object {

        private var sTaskDescription: ActivityManager.TaskDescription? = null
    }

}
