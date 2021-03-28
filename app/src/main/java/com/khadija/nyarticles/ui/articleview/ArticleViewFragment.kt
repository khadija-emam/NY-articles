package com.khadija.nyarticles.ui.articleview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.khadija.nyarticles.R
import com.khadija.nyarticles.databinding.ArticleViewBinding

class ArticleViewFragment:Fragment() {
    private lateinit var binding: ArticleViewBinding




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.article_view, container, false)
        binding.lifecycleOwner = this

        val args=ArticleViewFragmentArgs.fromBundle(requireArguments())
       binding.result=args.article

        binding.viewMore.setOnClickListener {
            val browserIntent =  Intent(Intent.ACTION_VIEW, Uri.parse(args.article.url));
            startActivity(browserIntent)
        }


        return binding.root
    }
    }