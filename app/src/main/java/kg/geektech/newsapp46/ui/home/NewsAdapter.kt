package kg.geektech.newsapp46.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.newsapp46.databinding.NewsItemBinding
import kg.geektech.newsapp46.models.News
import kg.geektech.newsapp46.ui.home.NewsAdapter.ViewHolder

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val list = arrayListOf<News>()


    inner class ViewHolder(private var binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.newsTitle.text = news.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsItemBinding.inflate(LayoutInflater.from
            (parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
    fun addItem(news: News) {
        list.add(0, news)
        notifyItemInserted(0)
    }


}