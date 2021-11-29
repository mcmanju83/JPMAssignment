package com.mcm.jpmassignment.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mcm.jpmassignment.R
import com.mcm.jpmassignment.databinding.AlbumActivityBinding
import com.mcm.jpmassignment.util.NetworkUtil
import com.mcm.jpmassignment.viewmodel.AblumViewModel

class AlbumActivity : AppCompatActivity() {
    lateinit var binding: AlbumActivityBinding
    var networkUtil: NetworkUtil = NetworkUtil()
    var albumViewModel: AblumViewModel = AblumViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.album_activity)
        showProgress(true)
        getData()
    }

    private fun showProgress(progress: Boolean) {
        if (progress) {
            binding.progress.visibility = View.VISIBLE
            binding.progress.animate()
        } else {
            binding.progress.stopNestedScroll()
            binding.progress.visibility = View.GONE
        }
    }

    fun getData() {
        if (networkUtil.isNetworkAvailable(this)) {
            albumViewModel.getTitles().observe(
                this
            ) {
                showProgress(false)
                it.onSuccess {
                    val albums = it.sortedBy { it.title }
                    binding.rvItems.adapter = AlbumAdapter(albums)
                }
                it.onFailure {
                    Toast.makeText(this, R.string.no_data_found, Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            showProgress(false)
            Toast.makeText(this, R.string.network_issue, Toast.LENGTH_SHORT).show()
        }
    }
}
