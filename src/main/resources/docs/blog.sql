/*
Navicat MySQL Data Transfer

Source Server         : 47.94.139.213_3306
Source Server Version : 50642
Source Host           : 47.94.139.213:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-01-09 17:21:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blog_info
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_info`;
CREATE TABLE `t_blog_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(11) DEFAULT NULL COMMENT '文章类型',
  `title` varchar(110) DEFAULT NULL COMMENT '文章标题',
  `content` longtext COMMENT '内容',
  `tags` varchar(16) DEFAULT NULL COMMENT '标签',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `status` varchar(11) DEFAULT NULL COMMENT '状态',
  `count` int(11) DEFAULT '0' COMMENT '次数',
  `url` varchar(255) DEFAULT NULL COMMENT '博客路径',
  `face` varchar(110) DEFAULT NULL COMMENT '封面',
  `abs` varchar(255) DEFAULT NULL COMMENT '摘要',
  `top` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog_info
-- ----------------------------
INSERT INTO `t_blog_info` VALUES ('39', '原创', '我的第一篇博客--写给自己', '啊发发发到付', '努力奋斗', '2018-12-30 21:32:12', 'admin', '1', '0', 'bloghtml/test.html', null, '人生的高度， 不是你看清了多少事， 而是你看轻了多少事。 心灵的宽度， 不是你认识了多少人， 而是你包容了多少人。 做人如山， 望万物，而容万物。 做人似水， 能进退，而知进退...', '\0');
INSERT INTO `t_blog_info` VALUES ('46', '原创', 'springboot文件上传', '<h1 style=\"text-align: center;\">springboot搞定文件上传</h1>\n<div>&nbsp;\n    <hr>&nbsp; &nbsp; 文件上传在项目当中非常常见。基本上就是通过流进行文件的传送，在springboot当中文件上传也是非常简单。</div>\n<h2>&nbsp; 第一步 pom文件内容</h2>\n<p>&nbsp; &nbsp;</p><pre style=\"background-color:#2b2b2b;color:#a9b7c6;font-family:\'宋体\';font-size:11.3pt;\"><span style=\"color:#e8bf6a;\">&lt;dependencies&gt;<br></span><span style=\"color:#e8bf6a;\">   &lt;dependency&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;groupId&gt;</span>org.springframework.boot<span style=\"color:#e8bf6a;\">&lt;/groupId&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;artifactId&gt;</span>spring-boot-starter-thymeleaf<span style=\"color:#e8bf6a;\">&lt;/artifactId&gt;<br></span><span style=\"color:#e8bf6a;\">   &lt;/dependency&gt;<br></span><span style=\"color:#e8bf6a;\">   &lt;dependency&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;groupId&gt;</span>org.springframework.boot<span style=\"color:#e8bf6a;\">&lt;/groupId&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;artifactId&gt;</span>spring-boot-starter-web<span style=\"color:#e8bf6a;\">&lt;/artifactId&gt;<br></span><span style=\"color:#e8bf6a;\">   &lt;/dependency&gt;<br></span><span style=\"color:#e8bf6a;\"><br></span><span style=\"color:#e8bf6a;\">   &lt;dependency&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;groupId&gt;</span>org.springframework.boot<span style=\"color:#e8bf6a;\">&lt;/groupId&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;artifactId&gt;</span>spring-boot-starter-test<span style=\"color:#e8bf6a;\">&lt;/artifactId&gt;<br></span><span style=\"color:#e8bf6a;\">      &lt;scope&gt;</span>test<span style=\"color:#e8bf6a;\">&lt;/scope&gt;<br></span><span style=\"color:#e8bf6a;\">   &lt;/dependency&gt;<br></span><span style=\"color:#e8bf6a;\">&lt;/dependencies&gt;</span></pre>\n<h2>&nbsp; 第二步 application配置信息</h2><p><br></p><pre><span class=\"line\"># 是否支持批量上传   (默认值 true)</span><br><span class=\"line\">spring.servlet.multipart.enabled=true</span><br><span class=\"line\"># 上传文件的临时目录 （一般情况下不用特意修改）</span><br><span class=\"line\">spring.servlet.multipart.location=</span><br><span class=\"line\"># 上传文件最大为 1M （默认值 1M ）</span><br><span class=\"line\">spring.servlet.multipart.max-file-size=1MB</span><br><span class=\"line\"># 上传请求最大为 10M（默认值10M）</span><br><span class=\"line\">spring.servlet.multipart.max-request-size=10MB</span><br><span class=\"line\"># 文件大小阈值，当大于这个阈值时将写入到磁盘，否则存在内存中，（默认值0 一般情况下不用特意修改）</span><br><span class=\"line\">spring.servlet.multipart.file-size-threshold=0</span></pre>\n<p>\n    <font color=\"#cc0000\" face=\"monospace\">注：如果上传的文件大小超过默认值会报错：org.apache.tomcat.util.http.fileupload.FileUploadBase$SizeLimitExceededExcep</font>\n</p>\n<h2>&nbsp;第三步 后台上传代码</h2><pre lay-lang=\"java\">@RestController\n@RequestMapping(\"/upload\")\npublic class UploadController extends BaseController {\n\n    @Value(\"${hjljy-upload-path}\")\n    private  String uploadPath;\n\n    @PostMapping(\"/upload1\")\n    public AjaxJson upload1(@RequestParam(\"file\") MultipartFile file, HttpServletRequest request) {\n        File targetFile = new File(uploadPath);\n        if (!targetFile.exists()) {\n            targetFile.mkdirs();\n        }\n        try {\n            FileOutputStream out = new FileOutputStream(uploadPath + file.getOriginalFilename());\n            out.write(file.getBytes());\n            out.flush();\n            out.close();\n        } catch (IOException e) {\n            logger.error(\"文件上传错误：\"+e.getMessage());\n        }\n        AjaxJson ajaxJson = new AjaxJson();\n        HashMap<string,string> list =new HashMap&lt;&gt;();\n        list.put(\"src\", \"/files/\"+file.getOriginalFilename());\n        ajaxJson.setSuccessData(list);\n        return ajaxJson;\n    }\n}</string,string></pre><p><string,string><font color=\"#cc0000\">注意事项：代码中的&nbsp;</font></string,string><span style=\"background-color: rgb(242, 242, 242); color: rgb(51, 51, 51); font-family: &quot;Courier New&quot;; font-size: 12px;\">uploadPath </span><span style=\"background-color: rgb(242, 242, 242); font-family: &quot;Courier New&quot;; font-size: 12px;\"><font color=\"#cc0000\">的值是外部文件夹：</font></span></p><p><span style=\"background-color: rgb(242, 242, 242); font-family: &quot;Courier New&quot;; font-size: 12px;\"><pre lay-lang=\"java\">hjljy-upload-path =/var/uploaded_files/</pre></span></p><p><font face=\"Courier New\"><span style=\"font-size: 12px; background-color: rgb(242, 242, 242);\">这是因为在使用springboot项目时，最后打包成jar运行时，每次运行jar都会新生成一个tomcat文件夹。之前上传的文件就获取不到了。所以需要在外部固定一个文件夹当成上传文件夹。</span></font></p><p><font face=\"Courier New\"><span style=\"font-size: 12px; background-color: rgb(242, 242, 242);\">同时需要添加代码：</span></font></p><pre style=\"background-color:#2b2b2b;color:#a9b7c6;font-family:\'宋体\';font-size:11.3pt;\"><span style=\"color:#bbb529;\">@Component<br></span><span style=\"color:#cc7832;\">public class </span>WebConfigurer <span style=\"color:#cc7832;\">implements </span>WebMvcConfigurer {<br><br>    <span style=\"color:#bbb529;\">@Value</span>(<span style=\"color:#6a8759;\">\"${hjljy-upload-path}\"</span>)<br>    <span style=\"color:#cc7832;\">private  </span>String <span style=\"color:#9876aa;\">uploadPath</span><span style=\"color:#cc7832;\">;<br></span><span style=\"color:#cc7832;\"><br></span><span style=\"color:#cc7832;\">    </span><span style=\"color:#bbb529;\">@Override<br></span><span style=\"color:#bbb529;\">    </span><span style=\"color:#cc7832;\">public void </span><span style=\"color:#ffc66d;\">addResourceHandlers</span>(ResourceHandlerRegistry registry) {<br>        registry.addResourceHandler(<span style=\"color:#6a8759;\">\"/files/**\"</span>).addResourceLocations(<span style=\"color:#6a8759;\">\"file://\"</span>+<span style=\"color:#9876aa;\">uploadPath</span>)<span style=\"color:#cc7832;\">;</span><span style=\"color:#cc7832;\"><br></span><span style=\"color:#cc7832;\">    </span>}<br>}</pre><p><span style=\"font-family: &quot;Courier New&quot;; font-size: 12px; background-color: rgb(242, 242, 242);\">代码的含义是：添加一个外部静态资源映射：所有的/files/** 请求会到uploadPath下面去找对应的静态资源。</span></p><p><span style=\"font-family: &quot;Courier New&quot;; font-size: 12px; background-color: rgb(242, 242, 242);\">例如：127.0.0.1/files/bg01.jpg这个请求实际的文件查找路径是找</span><span style=\"background-color: rgb(242, 242, 242); font-family: &quot;Courier New&quot;; font-size: 12px;\">uploadPath下面的bg01.jpg这个图片。</span></p><p><br></p><p>以上一个简单的文件上传就搞定了。</p>\n<h1>\n    <p>\n    </p>\n</h1>', 'springboot', '2019-01-02 07:03:54', 'admin', '1', '0', 'bloghtml/springboot文件上传1546412634447.html', null, '基于springboot文件上传的简单实现，通过文件流进行数据的传输，前端通过enctype=\"multipart/form-data\"进行数据传输声明，后端通过MultipartFile类进行文件的接受...', '\0');

-- ----------------------------
-- Table structure for t_sys_account
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_account`;
CREATE TABLE `t_sys_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `org_id` int(11) NOT NULL DEFAULT '1' COMMENT '组织ID',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(18) DEFAULT NULL COMMENT '用户名称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `status` bit(1) DEFAULT NULL COMMENT '状态',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `modified_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_account
-- ----------------------------
INSERT INTO `t_sys_account` VALUES ('1', '1', '1', '超级管理员', 'b7b12fc7fc7abd9acba810f8d6cbb7fa', 'admin', '921244819@qq.com', '18383394952', '中国', '', '1', '2019-01-03 15:27:37', 'admin', '2019-01-03 03:14:19', 'admin');
INSERT INTO `t_sys_account` VALUES ('2', '2', '1', null, '923ab36694fbca3ae37f881d2c4c02db', 'test', '921244819@qq.com', '13183629225', null, '\0', '0', '2019-01-03 11:04:01', 'admin', '2019-01-03 03:05:52', 'admin');

-- ----------------------------
-- Table structure for t_sys_firends
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_firends`;
CREATE TABLE `t_sys_firends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_firends
-- ----------------------------
INSERT INTO `t_sys_firends` VALUES ('1', '杨青个人博客', 'http://www.yangqq.com');
INSERT INTO `t_sys_firends` VALUES ('2', '我的github', 'https://github.com/FILWLL/');
INSERT INTO `t_sys_firends` VALUES ('3', '我的码云', 'https://gitee.com/hjljy');

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) DEFAULT NULL COMMENT '操作人',
  `user_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `response_time` int(11) DEFAULT NULL COMMENT '响应时间',
  `operation_ip` varchar(255) DEFAULT NULL COMMENT '操作的ip地址',
  `operation_method` varchar(255) DEFAULT NULL COMMENT '操作方法',
  `operation_desc` varchar(255) DEFAULT NULL COMMENT '操作描述',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `errorMsg` varchar(255) DEFAULT NULL COMMENT '错误信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------
INSERT INTO `t_sys_log` VALUES ('1', 'admin', '1', '37226', '127.0.0.1', 'com.hjljy.blog.controller.system.RecourcesController.addOrEdit()', '添加或者修改菜单信息', '2018-12-25 10:41:44', null);
INSERT INTO `t_sys_log` VALUES ('2', 'admin', '1', '3162', '127.0.0.1', 'com.hjljy.blog.controller.system.RecourcesController.addOrEdit()', '添加或者修改菜单信息', '2018-12-26 01:48:02', null);
INSERT INTO `t_sys_log` VALUES ('3', 'admin', '1', '141', '127.0.0.1', 'com.hjljy.blog.controller.system.RecourcesController.addOrEdit()', '添加或者修改菜单信息', '2018-12-26 06:55:40', null);
INSERT INTO `t_sys_log` VALUES ('4', 'admin', '1', '16569', '127.0.0.1', 'com.hjljy.blog.controller.system.RecourcesController.addOrEdit()', '添加或者修改菜单信息', '2018-12-26 06:58:03', null);
INSERT INTO `t_sys_log` VALUES ('5', 'admin', '1', '5680', '127.0.0.1', 'com.hjljy.blog.controller.system.RecourcesController.addOrEdit()', '添加或者修改菜单信息', '2019-01-03 02:17:14', null);
INSERT INTO `t_sys_log` VALUES ('6', 'admin', '1', '125', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:50:52', null);
INSERT INTO `t_sys_log` VALUES ('7', 'admin', '1', '125', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:51:31', null);
INSERT INTO `t_sys_log` VALUES ('8', 'admin', '1', '121', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:51:59', null);
INSERT INTO `t_sys_log` VALUES ('9', 'admin', '1', '121', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:52:53', null);
INSERT INTO `t_sys_log` VALUES ('10', 'admin', '1', '120', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:53:29', null);
INSERT INTO `t_sys_log` VALUES ('11', 'admin', '1', '124', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:56:07', null);
INSERT INTO `t_sys_log` VALUES ('12', 'admin', '1', '116', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:56:08', null);
INSERT INTO `t_sys_log` VALUES ('13', 'admin', '1', '82', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:56:08', null);
INSERT INTO `t_sys_log` VALUES ('14', 'admin', '1', '116', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:56:22', null);
INSERT INTO `t_sys_log` VALUES ('15', 'admin', '1', '80', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:56:23', null);
INSERT INTO `t_sys_log` VALUES ('16', 'admin', '1', '116', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:56:25', null);
INSERT INTO `t_sys_log` VALUES ('17', 'admin', '1', '80', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:56:25', null);
INSERT INTO `t_sys_log` VALUES ('18', 'admin', '1', '120', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:57:22', null);
INSERT INTO `t_sys_log` VALUES ('19', 'admin', '1', '82', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:57:22', null);
INSERT INTO `t_sys_log` VALUES ('20', 'admin', '1', '19184', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:58:17', null);
INSERT INTO `t_sys_log` VALUES ('21', 'admin', '1', '80', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:58:17', null);
INSERT INTO `t_sys_log` VALUES ('22', 'admin', '1', '116', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:58:19', null);
INSERT INTO `t_sys_log` VALUES ('23', 'admin', '1', '115', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:58:42', null);
INSERT INTO `t_sys_log` VALUES ('24', 'admin', '1', '8912', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:58:52', null);
INSERT INTO `t_sys_log` VALUES ('25', 'admin', '1', '79', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:58:52', null);
INSERT INTO `t_sys_log` VALUES ('26', 'admin', '1', '114', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:59:42', null);
INSERT INTO `t_sys_log` VALUES ('27', 'admin', '1', '2863', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:59:46', null);
INSERT INTO `t_sys_log` VALUES ('28', 'admin', '1', '77', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:59:46', null);
INSERT INTO `t_sys_log` VALUES ('29', 'admin', '1', '8972', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 02:59:57', null);
INSERT INTO `t_sys_log` VALUES ('30', 'admin', '1', '76', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 02:59:57', null);
INSERT INTO `t_sys_log` VALUES ('31', 'admin', '1', '113', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:00:00', null);
INSERT INTO `t_sys_log` VALUES ('32', 'admin', '1', '115', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:00:10', null);
INSERT INTO `t_sys_log` VALUES ('33', 'admin', '1', '2954', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:00:15', null);
INSERT INTO `t_sys_log` VALUES ('34', 'admin', '1', '77', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:00:15', null);
INSERT INTO `t_sys_log` VALUES ('35', 'admin', '1', '113', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:00:18', null);
INSERT INTO `t_sys_log` VALUES ('36', 'admin', '1', '79', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:00:57', null);
INSERT INTO `t_sys_log` VALUES ('37', 'admin', '1', '6538', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:01:07', null);
INSERT INTO `t_sys_log` VALUES ('38', 'admin', '1', '84', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:01:07', null);
INSERT INTO `t_sys_log` VALUES ('39', 'admin', '1', '113', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:01:16', null);
INSERT INTO `t_sys_log` VALUES ('40', 'admin', '1', '5292', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:01:23', null);
INSERT INTO `t_sys_log` VALUES ('41', 'admin', '1', '77', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:01:23', null);
INSERT INTO `t_sys_log` VALUES ('42', 'admin', '1', '167', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:02:24', null);
INSERT INTO `t_sys_log` VALUES ('43', 'admin', '1', '2633', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:02:29', null);
INSERT INTO `t_sys_log` VALUES ('44', 'admin', '1', '78', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:02:29', null);
INSERT INTO `t_sys_log` VALUES ('45', 'admin', '1', '3760', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:02:39', null);
INSERT INTO `t_sys_log` VALUES ('46', 'admin', '1', '78', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:02:40', null);
INSERT INTO `t_sys_log` VALUES ('47', 'admin', '1', '2760', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:02:52', null);
INSERT INTO `t_sys_log` VALUES ('48', 'admin', '1', '80', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:02:52', null);
INSERT INTO `t_sys_log` VALUES ('49', 'admin', '1', '95', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:05:03', null);
INSERT INTO `t_sys_log` VALUES ('50', 'admin', '1', '2718', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:05:08', null);
INSERT INTO `t_sys_log` VALUES ('51', 'admin', '1', '76', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:05:08', null);
INSERT INTO `t_sys_log` VALUES ('52', 'admin', '1', '2215', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:05:16', null);
INSERT INTO `t_sys_log` VALUES ('53', 'admin', '1', '83', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:05:16', null);
INSERT INTO `t_sys_log` VALUES ('54', 'admin', '1', '2356', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:05:22', null);
INSERT INTO `t_sys_log` VALUES ('55', 'admin', '1', '77', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:05:23', null);
INSERT INTO `t_sys_log` VALUES ('56', 'admin', '1', '2646', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:05:54', null);
INSERT INTO `t_sys_log` VALUES ('57', 'admin', '1', '78', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:05:54', null);
INSERT INTO `t_sys_log` VALUES ('58', 'admin', '1', '162', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:06:47', null);
INSERT INTO `t_sys_log` VALUES ('59', 'admin', '1', '8150', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:06:57', null);
INSERT INTO `t_sys_log` VALUES ('60', 'admin', '1', '78', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:06:58', null);
INSERT INTO `t_sys_log` VALUES ('61', 'admin', '1', '2572', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:12:49', null);
INSERT INTO `t_sys_log` VALUES ('62', 'admin', '1', '76', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:12:49', null);
INSERT INTO `t_sys_log` VALUES ('63', 'admin', '1', '41959', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:13:53', null);
INSERT INTO `t_sys_log` VALUES ('64', 'admin', '1', '77', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:13:53', null);
INSERT INTO `t_sys_log` VALUES ('65', 'admin', '1', '114', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:13:56', null);
INSERT INTO `t_sys_log` VALUES ('66', 'admin', '1', '4131', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:14:09', null);
INSERT INTO `t_sys_log` VALUES ('67', 'admin', '1', '77', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:14:09', null);
INSERT INTO `t_sys_log` VALUES ('68', 'admin', '1', '113', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:14:16', null);
INSERT INTO `t_sys_log` VALUES ('69', 'admin', '1', '79', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:14:16', null);
INSERT INTO `t_sys_log` VALUES ('70', 'admin', '1', '113', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.addOrEdit()', '添加或者编辑用户信息', '2019-01-03 03:14:19', null);
INSERT INTO `t_sys_log` VALUES ('71', 'admin', '1', '80', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 03:14:19', null);
INSERT INTO `t_sys_log` VALUES ('72', 'admin', '1', '89', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 06:56:13', null);
INSERT INTO `t_sys_log` VALUES ('73', 'admin', '1', '88', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:05:11', null);
INSERT INTO `t_sys_log` VALUES ('74', 'admin', '1', '132', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:05:44', null);
INSERT INTO `t_sys_log` VALUES ('75', 'admin', '1', '132', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:06:36', null);
INSERT INTO `t_sys_log` VALUES ('76', 'admin', '1', '133', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:07:32', null);
INSERT INTO `t_sys_log` VALUES ('77', 'admin', '1', '86', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:19:34', null);
INSERT INTO `t_sys_log` VALUES ('78', 'admin', '1', '87', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:29:17', null);
INSERT INTO `t_sys_log` VALUES ('79', 'admin', '1', '130', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.Rpwd()', '重置用户密码', '2019-01-03 07:29:28', null);
INSERT INTO `t_sys_log` VALUES ('80', 'admin', '1', '123', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:29:54', null);
INSERT INTO `t_sys_log` VALUES ('81', 'admin', '1', '84', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:33:47', null);
INSERT INTO `t_sys_log` VALUES ('82', 'admin', '1', '83', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 07:39:00', null);
INSERT INTO `t_sys_log` VALUES ('83', 'admin', '1', '89', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-03 08:56:30', null);
INSERT INTO `t_sys_log` VALUES ('84', 'admin', '1', '83', '127.0.0.1', 'com.hjljy.blog.controller.system.AccountController.getAccountByPage()', '查询用户信息', '2019-01-04 02:22:12', null);

-- ----------------------------
-- Table structure for t_sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resources`;
CREATE TABLE `t_sys_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `pid` int(11) DEFAULT NULL COMMENT '父级资源id',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `resource_url` varchar(110) DEFAULT NULL COMMENT '资源路径',
  `type` int(2) DEFAULT NULL COMMENT '类型：0 表示目录  1表示菜单 2表示按钮',
  `perms` varchar(110) DEFAULT NULL COMMENT '授权',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标样式',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `locked` bit(1) DEFAULT NULL COMMENT '是否禁用：1表示禁用 0 表示未禁用',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_resources
-- ----------------------------
INSERT INTO `t_sys_resources` VALUES ('1', '0', '系统管理', null, '0', null, null, '1', '\0', null, '2018-12-06 17:02:07', null);
INSERT INTO `t_sys_resources` VALUES ('2', '1', '用户管理', '/system/account/index', '1', 'sys:account:index', null, '2', '\0', null, '2018-12-06 17:00:50', null);
INSERT INTO `t_sys_resources` VALUES ('3', '1', '角色管理', '/system/role/index', '1', 'sys:role:index', null, '3', '\0', null, '2018-12-06 18:14:15', null);
INSERT INTO `t_sys_resources` VALUES ('4', '1', '菜单管理', '/system/resources/index', '1', 'sys:resources:index', null, '4', '\0', null, '2018-12-06 18:14:18', null);
INSERT INTO `t_sys_resources` VALUES ('5', '2', '增加用户', '/system/account/addOrEdit', '2', 'sys:account:add', null, '5', '\0', null, '2018-12-06 18:14:20', null);
INSERT INTO `t_sys_resources` VALUES ('6', '0', '测试一下', null, '0', null, null, '2', '\0', null, '2018-12-11 10:29:55', null);
INSERT INTO `t_sys_resources` VALUES ('7', '6', '二级菜单', '', '1', null, null, '2', '\0', null, null, null);
INSERT INTO `t_sys_resources` VALUES ('8', '0', '博客管理', null, '0', null, null, '1', '\0', null, '2018-12-25 10:32:27', null);
INSERT INTO `t_sys_resources` VALUES ('9', '8', '博客列表', '/blog/index', '1', 'sys:blog:index', null, '1', '\0', null, '2018-12-25 10:41:07', null);
INSERT INTO `t_sys_resources` VALUES ('10', '9', '添加博客', '/blog/add', '2', 'sys:blog:add', null, '1', '\0', null, '2018-12-26 01:47:59', null);
INSERT INTO `t_sys_resources` VALUES ('11', '9', '删除博客', '/blog/del', '2', 'sys:blog:del', null, '1', '\0', null, '2018-12-26 06:55:40', null);
INSERT INTO `t_sys_resources` VALUES ('12', '6', 'TEST', null, '1', null, null, '11', '\0', null, '2018-12-26 06:57:46', null);
INSERT INTO `t_sys_resources` VALUES ('13', '2', '删除用户', '/system/account/del', '2', 'sys:account:del', null, '5', '\0', null, '2019-01-03 02:17:09', null);
INSERT INTO `t_sys_resources` VALUES ('14', '2', '重置密码', '/system/account/rpwd', '2', 'sys:account:rpwd', null, '4', '\0', null, '2019-01-03 10:41:42', null);

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `english_name` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员', 'sys', '2018-12-06 17:39:30', null, '超级管理员');
INSERT INTO `t_sys_role` VALUES ('2', '测试人员', 'test', '2018-12-21 15:00:12', null, '测试的');

-- ----------------------------
-- Table structure for t_sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_resources`;
CREATE TABLE `t_sys_role_resources` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '资源ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `t_sys_role_resources_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`),
  CONSTRAINT `t_sys_role_resources_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `t_sys_resources` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_resources
-- ----------------------------
INSERT INTO `t_sys_role_resources` VALUES ('1', '1', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '2', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '3', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '4', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '5', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '6', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '7', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '8', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '9', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '10', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '11', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '12', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '13', '2019-01-03 02:18:03', null);
INSERT INTO `t_sys_role_resources` VALUES ('1', '14', '2019-01-03 10:51:21', null);
