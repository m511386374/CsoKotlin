package com.glgs.cso.mvp.model.entity

import java.util.Comparator

/**
 * 作    者：MingMeng
 * 创建日期：2019/10/8
 * 描    述：
 */
class KnowledgeAssessmentDetailsBean {
    /**
     * intro : 历史
     * introduce : 历史考试
     * title : 中国有多少个少数名族
     * score : 5
     * iscorrect : 3
     * answerresults : 2,
     * anseriscorrect : 1
     * questiontype : 0
     * exameQuestionList : [{"optionvalue":"56","sortnum":3},{"optionvalue":"54","sortnum":1},{"optionvalue":"55","sortnum":2},{"optionvalue":"57","sortnum":4}]
     */

    var intro: String? = null
    var introduce: String? = null
    var title: String? = null
    var score: Int = 0
    var iscorrect: String? = null
    var answerresults: String? = null
    var anseriscorrect: String? = null
    var questiontype: String? = null
    var exameQuestionList: List<ExameQuestionListBean>? = null

    class ExameQuestionListBean : Comparator<ExameQuestionListBean> {
        /**
         * optionvalue : 56
         * sortnum : 3
         */

        var optionvalue: String? = null
        var sortnum: Int = 0

        override fun compare(o1: ExameQuestionListBean, o2: ExameQuestionListBean): Int {
            return o1.sortnum - o2.sortnum//升序
        }
    }
}
