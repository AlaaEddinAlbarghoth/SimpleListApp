package com.alaaeddinalbarghoth.simplelistapp.presentation


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.webkit.URLUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaaeddinalbarghoth.simplelistapp.data.local.FeedItem
import com.alaaeddinalbarghoth.simplelistapp.data.local.FeedsResponse
import com.alaaeddinalbarghoth.simplelistapp.domain.DownloadUseCase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
    private val downloadUseCase: DownloadUseCase
) : ViewModel() {

    val _items = MutableLiveData<List<FeedItem>>()
    val items: LiveData<List<FeedItem>> = _items

    companion object {
        const val Json_File =
            "https://api.rss2json.com/v1/api.json?rss_url=https://mars.nasa.gov/rss/blogs.cfm"
    }

    fun downloadJsonFile() {

        viewModelScope.launch {
            val asd = downloadUseCase.downloadFile(Json_File)
            Log.e(this@MainViewModel.javaClass.simpleName, asd.toString())
            saveFile(context, downloadUseCase.downloadFile(Json_File))?.let { file ->
                Log.e(this@MainViewModel.javaClass.simpleName, file.toString())
                file.inputStream().bufferedReader().use { it.readText() }.also { contents ->
                    gson.fromJson(contents, FeedsResponse::class.java).run {
                        _items.value = this.feedItems
                    }
                }
            }
        }
    }

    private fun saveFile(context: Context, body: ResponseBody?): File? {
        val fileName = URLUtil.guessFileName(Json_File, null, null)
        val pathWhereYouWantToSaveFile =
            context.applicationContext.filesDir.absolutePath + File.separator + fileName

        if (body == null)
            return null
        var input: InputStream? = null
        try {
            input = body.byteStream()
            val fos = FileOutputStream(pathWhereYouWantToSaveFile)
            fos.use { output ->
                val buffer = ByteArray(4 * 1024) // or other buffer size
                var read: Int
                while (input.read(buffer).also { read = it } != -1) output.write(buffer, 0, read)
                output.flush()
            }
            return File(pathWhereYouWantToSaveFile)
        } catch (e: Exception) {
            Log.e(this@MainViewModel.javaClass.simpleName, "saveFile => e")
        } finally {
            input?.close()
        }
        return null
    }
}