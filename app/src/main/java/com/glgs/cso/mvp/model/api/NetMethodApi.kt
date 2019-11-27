package com.glgs.cso.mvp.model.api

/**
 * 作    者：MingMeng
 * 创建日期：2019/2/20
 * 描    述：网络接口的方法名
 */
object NetMethodApi {
    //APPJSON
   const val NET_METHOD_APP_JSON = "api/appmanager/gianAppJsonData"
    //登录
    const val NET_METHOD_USER_LOGIN = "api/user/login"
    //验证手机号
    const val NET_METHOD_VERIFICATION_PHONE = "api/user/findMobileno"
    //获取验证码
    const val NET_METHOD_GET_VERIFICATIONCODE = "api/user/createVerificationCode"
    //验证验证码
    const val NET_METHOD_FINDVERIFICATIONCODE = "api/user/findVerificationCode"
    //验证验证码
    const val NET_METHOD_UPDATEPASSWORD = "api/user/updatePassword"
    //上传文件
    const val NET_METHOD_UPLOAD_FILES = "api/file/upload"
    //审批人员
    const val NET_METHOD_APPROVEPERSONNEL = "api/appuser/query"
    //待我审批
    const val NET_METHOD_PENDINGAPPROVE = "api/approve/queryNoApprove"
    //我已审批
    const val NET_METHOD_PENDEDAPPROVE = "api/approve/queryAlready"
    //我发起的审批
    const val NET_METHOD_BUILDINGAPPROVE = "api/approve/queryById"
    //抄送我的审批
    const val NET_METHOD_COPEAPPROVE = "api/approve/queryCopy"
    //审批详情
    const val NET_METHOD_APPROVEDETAILS = "api/approve/findById"
    //新建通用审批
    const val NET_METHOD_NEWBUILDCOMMONAPPROVE = "api/approve/createGeneral"
    //新建出差审批
    const val NET_METHOD_NEWBUILDTRIPAPPROVE = "api/approve/createEvectiontrip"
    //新建外出审批
    const val NET_METHOD_NEWBUILDGOOUTAPPROVE = "api/approve/createGoout"
    //新建请假审批
    const val NET_METHOD_NEWBUILDPERSONALLEAVEAPPROVE = "api/approve/createLeave"
    //新建补卡审批
    const val NET_METHOD_NEWBUILDPATCHCARDAPPROVE = "api/approve/createMendatte"
    //审批操作
    const val NET_METHOD_REVOKEAPPROVE = "api/approve/editApprove"
    //轮播图
    const val NET_METHOD_GETBANNER = "api/bannar/qeuery"
    //通知列表
    const val NET_METHOD_NOTIFICATIONMANAGEMENTLIST = "api/notification/query"
    //通知详情
    const val NET_METHOD_NOTIFICATIONMANAGEMENTDETAILS = "api/notification/find"
    //删除通知
    const val NET_METHOD_DELETENOTIFICATIONMANAGEMENT = "api/notification/del"
    //下一条通知
    const val NET_METHOD_NEXTNOTIFICATIONMANAGEMENTDETAILS = "api/notification/finds"
    //修改头像
    const val NET_METHOD_EDITHEADIMG = "api/appuser/editHeadimg"
    //修改密码
    const val NET_METHOD_EDITPASSWORD = "api/appuser/editpassword"

    // 查询考勤人员列表
    const val NET_METHOD_GETATTENDANCEPERSONNELLIST = "api/attendance/queryUser"
    // 创建考勤组
    const val NET_METHODCREATEATTENDANCE = "api/attendance/create"
    // 修改考勤组
    const val NET_METHODEDITATTENDANCE = "api/attendance/edit"
    // 获取考勤规则信息
    const val NET_METHODGETATTENDANCERULE = "api/attendance/findAtte"
    // 发票列表
    const val NET_METHODGETINVOICELIST = "api/invoice/query"
    // 发票详情
    const val NET_METHODINVOICEDETAILS = "api/invoice/find"
    // 查看发票详情（图片）
    const val NET_METHODGETINVOICEIMAGE = "api/invoice/findImgUrl"
    // 发送邮件
    const val NET_METHODSENDINVOICEEMAIL = "api/invoice/createMail"


    //任务申请
    const val NET_METHOD_TASKAPPLY = "api/taskissue/apply"
    //任务申请记录
    const val NET_METHOD_TASKAPPLYRECORD = "api/taskissue/applyrecord"
    //任务任务列表
    const  val NET_METHOD_GETTASKLIST = "api/taskissue/queryTaskCondition"

    //任务详情
    const val NET_METHOD_TASKDETAILS = "api/taskissue/taskdetail"
    //待认领认务列表
    const val NET_METHOD_GETWAITTASKLIST = "api/taskissue/waitclaimlist"
    //任务申请详情
    const val NET_METHOD_TASKAPPLYDETAIL = "api/taskissue/detail"
    //派发人员列表
    const val NET_METHOD_TASKDISTRIBUTIONLIST = "api/tasksell/queryTaskSellList"
    //添加任务派发人员
    const val NET_METHOD_TASKDISTRIBUTION = "api/tasksell/addTaskSellPerson"
    //提交结单
    const val NET_METHOD_TASKSUBMITSTATEMENT = "api/taskissue/submitcheck"
    //任务总结
    const val NET_METHOD_TASKSUBMITSUMMARY = "api/tasksummary/create"
    //
    const val NET_METHOD_TASKSUMMARYDETAIL = "api/tasksummary/detail"
    //子账号列表
    const val NET_METHOD_ACCOUNTLIST = "api/user/getAccountList"
    //子账号列表
    const val NET_METHOD_DELETEACCOUNT = "api/user/deleteAccount"
    //修改主账号
    const  val NET_METHOD_UPDATEPARMYACCOUNT = "api/user/updateParmyAccount"
    //任务签到
    const val NET_METHOD_TASKSIGNIN = "api/manageAttendance/comeWork"
    //待开票列表
    const val NET_METHOD_INVOICINGLIST = "api/taskissue/querywaitopenticket"
    //开票历史
    const val NET_METHOD_INVOICINGRECORD = "api/taskissue/history"
    //创建子账号
    const val NET_METHOD_ADDCHILDRENACCOUNT = "api/user/createSubaccount"
    //考试列表
    const val NET_METHOD_KNOWLEDGEASSESSMENTLIST = "api/assess/exameList"
    //任务总结签到详情
    const val NET_METHOD_TASKSUMMARYSIGNINDETAILS = "api/manageAttendance/detail"
    //删除总结
    const val NET_METHOD_DELETETASKSUMMARY = "api/tasksummary/delete"
    //编辑总结
    const val NET_METHOD_TASKEDITSUMMARY = "api/tasksummary/modify"
    //获取试考核详情
    const val NET_METHOD_KNOWLEDGEASSESSMENTINTRODUCE = "api/assess/getExamScoreResult"

    //开始答题
    const val NET_METHOD_MAKEKNOWLEDGEASSESSMENT = "api/assess/getExamquestions"
    //提交答题
    const val NET_METHOD_SUBMITANSWERS = "api/assess/insertExamResult"
    //开票
    const val NET_METHOD_OPENTICKET = "api/invoice/openticket"
    //查看考核结果详情
    const val NET_METHOD_KNOWLEDGEASSESSMENTDETAILS = "api/assess/queryExamMyResultList"
    //重新结单
    const val NET_METHOD_RESETSUBMITCHECK = "api/taskissue/resetsubmitcheck"

}
