package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/10/18
 * 描    述：
 */
class AppBean {

    /**
     * id :
     * appName : 娃哈哈
     * appIcon : http://120.25.78.1:6002/image/other/734a763330c74f2194d9472197de5c18.jpg
     * startPage : http://120.25.78.1:6002/image/other/2bd2b57fe8ad4902b85dfe7e7931b275.jpg
     * color : #5336f7
     * colorName : systemYellow
     * guidePage : ["http://120.25.78.1:6002/image/other/828ac9dce59c4a8882e4e4dbe995a824.jpg","http://120.25.78.1:6002/image/other/b9fb4e66566148aa826b54ae92c1f72c.jpg","http://120.25.78.1:6002/image/other/7255a6c190df402097cd4c3f814fa217.jpg"]
     * appWidth : 375.0
     * appHeight : 561.0
     * isshowLogo : 1
     * loginBg : http://120.25.78.1:6002/image/other/03abe9139de64eb6927d287f3412854f.jpg
     * loginIcon : http://120.25.78.1:6002/image/other/5b1253e61b03401e9eee151224c4f074.jpg
     * consolePage : {"bannarPage":{"height":203,"imgUrl":["http://120.25.78.1:6002/image/other/e268b9ea182e4b11b2056c22afe705ec.jpg","http://120.25.78.1:6002/image/other/5e252234971c47ea8f50a9596b504a56.jpg","http://120.25.78.1:6002/image/other/803db89cb4b9441a8f071f4a4d18412a.jpg","http://120.25.78.1:6002/image/other/049be67409014c2a86003192390e06c1.jpg"],"isAutoPlay":1,"speed":"2000"},"moduleList":[{"color":"#5596f7","height":102,"iconUrl":"task_publish_icon1","moduleCode":"0002","name":"任务领取","wide":110,"xAxle":14,"yAxle":217},{"color":"#5596f7","height":102,"iconUrl":"task_icon1","moduleCode":"0003","name":"我的任务","wide":110,"xAxle":132,"yAxle":217},{"color":"#5596f7","height":102,"iconUrl":"attendance_icon1","moduleCode":"0004","name":"考勤打卡","wide":110,"xAxle":250,"yAxle":217},{"color":"#5596f7","height":102,"iconUrl":"approve_icon1","moduleCode":"0005","name":"流程审批","wide":110,"xAxle":14,"yAxle":327},{"color":"#5596f7","height":102,"iconUrl":"notice_icon1","moduleCode":"0007","name":"通知公告","wide":110,"xAxle":132,"yAxle":327},{"color":"#5596f7","height":102,"iconUrl":"invoice_icon1","moduleCode":"0008","name":"我的发票","wide":110,"xAxle":250,"yAxle":327},{"color":"#5596f7","height":102,"iconUrl":"knowledge_icon1","moduleCode":"0006","name":"知识考核","wide":110,"xAxle":14,"yAxle":437}]}
     * pageLabel : {"homePageIconUrl":"management_center_icon1","homePageName":"控制台","personalCenterName":"个人中心","personalIconUrl":"personal_center_icon1"}
     * perlCenterModuleList : [{"height":104,"moduleCode":"1001","moduleName":"个人信息","xAxle":0,"yAxle":0},{"height":52,"moduleCode":"1002","moduleName":"子帐号管理","xAxle":0,"yAxle":114},{"height":52,"moduleCode":"1003","moduleName":"修改密码","xAxle":0,"yAxle":174}]
     * module :
     */

    var id: String? = null
    var appName: String? = null
    var appIcon: String? = null
    var startPage: String? = null
    var color: String? = null
        get() {
            if (field == "") {
                this.color = "#5596F7"
            }
            return field
        }
    var colorName: String? = null
    var isshowLogo: Int = 0
    var appWidth: Float? = null
    var appHeight: Float? = null
    var loginBg: String? = null
    var loginIcon: String? = null
    var consolePage: ConsolePageBean? = null
    var pageLabel: PageLabelBean? = null
    var guidePage: List<String>? = null
    var perlCenterModuleList: List<PerlCenterModuleListBean>? = null

    class ConsolePageBean {
        /**
         * bannarPage : {"height":203,"imgUrl":["http://120.25.78.1:6002/image/other/e268b9ea182e4b11b2056c22afe705ec.jpg","http://120.25.78.1:6002/image/other/5e252234971c47ea8f50a9596b504a56.jpg","http://120.25.78.1:6002/image/other/803db89cb4b9441a8f071f4a4d18412a.jpg","http://120.25.78.1:6002/image/other/049be67409014c2a86003192390e06c1.jpg"],"isAutoPlay":1,"speed":"2000"}
         * moduleList : [{"color":"#5596f7","height":102,"iconUrl":"task_publish_icon1","moduleCode":"0002","name":"任务领取","wide":110,"xAxle":14,"yAxle":217},{"color":"#5596f7","height":102,"iconUrl":"task_icon1","moduleCode":"0003","name":"我的任务","wide":110,"xAxle":132,"yAxle":217},{"color":"#5596f7","height":102,"iconUrl":"attendance_icon1","moduleCode":"0004","name":"考勤打卡","wide":110,"xAxle":250,"yAxle":217},{"color":"#5596f7","height":102,"iconUrl":"approve_icon1","moduleCode":"0005","name":"流程审批","wide":110,"xAxle":14,"yAxle":327},{"color":"#5596f7","height":102,"iconUrl":"notice_icon1","moduleCode":"0007","name":"通知公告","wide":110,"xAxle":132,"yAxle":327},{"color":"#5596f7","height":102,"iconUrl":"invoice_icon1","moduleCode":"0008","name":"我的发票","wide":110,"xAxle":250,"yAxle":327},{"color":"#5596f7","height":102,"iconUrl":"knowledge_icon1","moduleCode":"0006","name":"知识考核","wide":110,"xAxle":14,"yAxle":437}]
         */

        var bannarPage: BannarPageBean? = null
        var moduleList: List<ModuleListBean>? = null

        class BannarPageBean {
            /**
             * height : 203.0
             * imgUrl : ["http://120.25.78.1:6002/image/other/e268b9ea182e4b11b2056c22afe705ec.jpg","http://120.25.78.1:6002/image/other/5e252234971c47ea8f50a9596b504a56.jpg","http://120.25.78.1:6002/image/other/803db89cb4b9441a8f071f4a4d18412a.jpg","http://120.25.78.1:6002/image/other/049be67409014c2a86003192390e06c1.jpg"]
             * isAutoPlay : 1
             * speed : 2000
             */

            var height: Float? = null
            var isAutoPlay: Int = 0
            var speed: String? = null
            var imgUrl: List<String>? = null
        }

        class ModuleListBean {
            /**
             * color : #5596f7
             * height : 102.0
             * iconUrl : task_publish_icon1
             * moduleCode : 0002
             * name : 任务领取
             * wide : 110.0
             * xAxle : 14.0
             * yAxle : 217.0
             */

            var color: String? = null
            var height: Float? = null
            var iconUrl: String? = null
            var moduleCode: String? = null
            var name: String? = null
            var wide: Float? = null
            var xAxle: Float? = null
            var yAxle: Float? = null
        }
    }

    class PageLabelBean {
        /**
         * homePageIconUrl : management_center_icon1
         * homePageName : 控制台
         * personalCenterName : 个人中心
         * personalIconUrl : personal_center_icon1
         */

        var homePageIconUrl: String? = null
        var homePageName: String? = null
        var personalCenterName: String? = null
        var personalIconUrl: String? = null
    }

    class PerlCenterModuleListBean {
        /**
         * height : 104.0
         * moduleCode : 1001
         * moduleName : 个人信息
         * xAxle : 0.0
         * yAxle : 0.0
         */

        var height: Float? = null
        var moduleCode: String? = null
        var moduleName: String? = null
        var xAxle: Float? = null
        var yAxle: Float? = null
    }

}
