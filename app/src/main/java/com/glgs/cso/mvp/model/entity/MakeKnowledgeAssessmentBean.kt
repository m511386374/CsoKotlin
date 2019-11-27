package com.glgs.cso.mvp.model.entity

import java.util.Comparator

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/29
 * 描    述：
 */
class MakeKnowledgeAssessmentBean {
    /**
     * score : 5
     * questiontypeString :
     * title : 中国有多少个少数名族
     * questionAnswerList : [{"optionvalue":"56","sortnum":3},{"optionvalue":"54","sortnum":1},{"optionvalue":"55","sortnum":2},{"optionvalue":"57","sortnum":4}]
     * id : 28
     */

    var score: Int = 0
    var questiontype: String? = null
        private set
    var title: String? = null
    var id: Int = 0
    var total: Int = 0
    var questionAnswerList: List<QuestionAnswerListBean>? = null

    fun setQuestiontypeString(questiontype: String) {
        this.questiontype = questiontype
    }

    class QuestionAnswerListBean : Comparator<QuestionAnswerListBean> {
        /**
         * optionvalue : 56
         * sortnum : 3
         */

        var optionvalue: String? = null
        var sortnum: Int = 0
        var isSelect = false

        override fun compare(o1: QuestionAnswerListBean, o2: QuestionAnswerListBean): Int {
            return o1.sortnum - o2.sortnum
        }
    }

}
