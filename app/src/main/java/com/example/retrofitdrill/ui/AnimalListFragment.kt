package com.example.retrofitdrill.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.retrofitdrill.BuildConfig
import com.example.retrofitdrill.R
import com.example.retrofitdrill.databinding.FragmentAnimalListBinding
import com.example.retrofitdrill.network.model.Item


class AnimalListFragment : Fragment() {

    private val viewModel: AnimalListViewModel by viewModels()

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    private var list: List<Item>? = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(BuildConfig.API_KEY)
        println(viewModel.animalList.value?.get(0)?.age.toString())
        setupRecyclerView()
        viewModel.getAnimalInfo()

    }

    private fun setupRecyclerView() {
        val animalListAdapter = AnimalListRVAdapter()
        binding.rvAnimalList.apply {
            adapter = animalListAdapter
        }
        viewModel.animalList.observe(viewLifecycleOwner) {
            list = viewModel.animalList.value
            animalListAdapter.submitList(list)
        }
    }

    private fun loadData() = listOf(
        Item(
            desertionNo = "444450202101068",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "644450202101069",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "544450202101098",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "844450202101168",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "234450202101068",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "124450202101068",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "344450202101068",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        ),
        Item(
            desertionNo = "674450202101068",
            filename = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258_s.jpg",
            happenDt = "20211231",
            happenPlace = "공주시 우금티터널",
            kindCd = "[개] 믹스견",
            colorCd = "갈색",
            age = "2019(년생)",
            weight = "5(Kg)",
            noticeNo = "충남-공주-2022-00001",
            noticeSdt = "20220104",
            noticeEdt = "20220117",
            popfile = "http://www.animal.go.kr/files/shelter/2021/12/202201041101258.png",
            processState = "종료(반환)",
            sexCd = "M",
            neuterYn = "N",
            specialMark = "파란색목줄착용, 겁이많음,진드기, 털엉킴, 치석증, 심장사상충감염의심",
            careNm = "공주시 동물보호소",
            careTel = "041-853-7575",
            careAddr = "충청남도 공주시 감영길 7 (반죽동) ",
            orgNm = "충청남도 공주시",
            chargeNm = "동물보호팀",
            officetel = "041-840-3495"
        )
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}