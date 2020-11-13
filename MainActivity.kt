package com.example.ourmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(hibari)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.home -> {
            hibari.setImageResource(R.drawable.bird_hibari)
            menuText.text = ""
            return true
            }
            R.id.bifun -> {
                hibari.setImageResource(R.drawable.food_bi_fun)
                menuText.text = getString(R.string.bifun_text)
                return true
            }
            R.id.carbonara -> {
                hibari.setImageResource(R.drawable.food_spaghetti_carbonara)
                menuText.text = getString(R.string.carbonara_text)
                return true
            }
            R.id.neapolitan -> {
                hibari.setImageResource(R.drawable.food_spaghetti_neapolitan)
                menuText.text = getString(R.string.neapolitan_text)
                return true
            }
            R.id.yakisoba -> {
                hibari.setImageResource(R.drawable.food_omatsuri_yakisoba)
                menuText.text = getString(R.string.yakisoba_text)
                return true
            }
            R.id.ramen -> {
                hibari.setImageResource(R.drawable.ramen_top_syouyu)
                menuText.text = getString(R.string.ramen_text)
                return true
            }
            R.id.nyumen -> {
                hibari.setImageResource(R.drawable.food_nyuumen)
                menuText.text = getString(R.string.nyumen_text)
                return true
            }
            R.id.okonomiyaki -> {
                hibari.setImageResource(R.drawable.food_okonomiyaki_kyabetsuyaki_decoration)
                menuText.text = getString(R.string.okonomiyaki_text)
                return true
            }
            R.id.sandwich -> {
                hibari.setImageResource(R.drawable.food_sandwich_blt)
                menuText.text = getString(R.string.sandwich_text)
                return true
            }
            R.id.saucekatsudon -> {
            hibari.setImageResource(R.drawable.food_sauce_katsudon_fukui)
            menuText.text = getString(R.string.saucekatsudon_text)
            return true
            }
            R.id.moyashiitame -> {
                hibari.setImageResource(R.drawable.food_moyashi_niku_itame)
                menuText.text = getString(R.string.moyashiitame_text)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menuText.text.isNotEmpty()) {
            menuInflater.inflate(R.menu.context, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "${menuText.text}が食べたいです"
                val uri = Uri.fromParts("mailto", "setouchikoshinja@gmail.com", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.sms -> {
                val text = "${menuText.text}が食べたいです"
                val uri = Uri.fromParts("smsto", "99999999999", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}