package com.glgs.cso.app.config
import com.glgs.cso.mvp.model.entity.AppBean
/**
 * 作    者：MingMeng
 * 创建日期：2019/2/20
 * 描    述：常量配置
 */
object ConstantConfig {
    //第一次引导页
    val FIRST_GUIDE_PAGE = "first_guide_page"
    //账号
    val SP_ACOUNT = "acount"
    //密码
    val SP_PASSWORD = "password"
    //密码
    val SP_ACCESTOKEN = "token"
    val JPUSH_DATE = "jpush_date"
    //用户登录bean
    val USER_LOGIN_DATE_BEAN = "user_login_date_bean"
    //Appbean
    val USER_APP_DATE_BEAN = "app_date_bean"
    //手机号
    val PHONE = "mobileno"
    //公司码
    val COMPANYCODE = "platformcode"
    //密码
    val PASSWORD = "password"
    //验证码
    val VALIDATECODE = "validatecode"
    /**
     * 搜索返回的经度地址
     */
    val MAP_SEARCH_LONGITUDE = "MAP_SEARCH_LONGITUDE"
    /**
     * 搜索返回的纬度地址
     */
    val MAP_SEARCH_LATITUDE = "MAP_SEARCH_LATITUDE"
    /**
     * 搜索返回的地址
     */
    val MAP_SEARCH_ADDRESS = "MAP_SEARCH_ADDRESS"

    /**
     * 搜索返回的地址
     */
    val MAP_SEARCH_POIINFO = "MAP_SEARCH_POIINFO"
    val MAP_SEARCH_CODE = 505
    val MAP_SELECT_CODE = 504
    val AppWidth = 375
    val INTENT_WHERE = "type"
    val CODE_0 = 0
    val CODE_1 = 1
    val CODE_2 = 2
    val CODE_3 = 3
    val CODE_4 = 4
    val KEY_CODE_0 = "CODE_0"
    val KEY_CODE_1 = "CODE_1"
    val KEY_CODE_2 = "CODE_2"
    val KEY_CODE_3 = "CODE_3"
    val KEY_CODE_4 = "CODE_4"
    val KEY_CODE_5 = "CODE_5"
    val KEY_CODE_6 = "CODE_6"
    val REQUEST_CODE_100 = 100
    val REQUEST_CODE_101 = 101
    val REQUEST_CODE_102 = 102
    val REQUEST_CODE_103 = 103
    val REQUEST_CODE_104 = 104

    val RESULT_CODE_1001 = 1001
    val RESULT_CODE_1002 = 1002
    val RESULT_CODE_1003 = 1003
    val RESULT_CODE_1004 = 1004
    val RESULT_CODE_1005 = 1005

    val REQUESTCODE_FROM_NEW_BUILD_APPROVE_TO_ADDRESS_BOOK = 100
    val REQUESTCODE_FROM_NEW_BUILD_COPY_TO_ADDRESS_BOOK = 200
    val INTENT_RETURN_DATE = "datebean"
    var moduleListBean: Map<String?, AppBean.ConsolePageBean.ModuleListBean>? = null
    var perlCenterModuleListBean: Map<String, AppBean.PerlCenterModuleListBean>? = null
    var appBean: AppBean? = null

}
