layui.use(['table', 'form', 'layer'], function () {
    var table = layui.table,
        layer = layui.layer,
        $ = layui.$,
        form = layui.form;
    tableInit();
    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'add':
                openForm();
                break;
            case 'delBatch':
                layer.confirm('确认删除么？', {anim: 6, offset: '100px'}, function (index) {
                    var data = checkStatus.data;
                    var ids = [];
                    for (var i = 0; i < data.length; i++) {
                        ids.push(data[i].id);
                    }
                    delBatch(ids.toString());
                    layer.close(index);
                });
                break;
        }
        ;
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        var id = data.id;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', {anim: 6, offset: '100px'}, function (index) {
                delBatch(id);
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            openForm(data);
        } else if (obj.event === 'repwd') {
            layer.prompt({
                formType: 1,
                title: '请输入新密码',
                offset: 't',
                area: ['800px', '350px'] //自定义文本域宽高
            }, function (value, index, elem) {
                setNpwd({pwd:value,id:id});
                alert(value); //得到value
                layer.close(index);
            });
        }
    });
    //监听性别操作
    form.on('switch(sexDemo)', function (obj) {
        var id = $(this).attr("data-id");
        var sex = this.value;
        if (this.value == 1) {
            sex = 0;
        } else {
            sex = 1;
        }
        addOrEdit({sex: sex, id: id});
    });
    //监听锁定操作
    form.on('checkbox(lockDemo)', function (obj) {
        var id = $(this).attr("data-id");
        console.log(this.value)
        if (this.value == 'false') {
            status = true;
        } else {
            status = false;
        }
        addOrEdit({status: status, id: id});
    });
    //监听编辑表单提交操作
    form.on('submit(formDemo)', function (data) {
        if (data.field.status != true) {
            data.field.status = false
        }
        addOrEdit(data.field);
        document.getElementById("testlayer").reset();
        $("#testlayer").addClass("layui-hide");
        layer.closeAll('page');
    });
    //监听查询表单提交操作
    form.on('submit(formSearch)', function (data) {
        console.log(data.field);
        layer.msg('还未进行开发', {icon: 5});
    });

    /**重置密码 */
    function setNpwd(pwd) {
        $.ajax({
            url: "/system/account/rpwd"
            , data: pwd
            , async: false
            , type: "post"
            , dataType: "json"
            , success: function (data) {
                if (data.success) {
                    layer.msg(data.msg, {icon: 1});
                } else {
                    layer.msg(data.msg, {icon: 2});
                }
            }
        });
    }

    /**表格初始化*/
    function tableInit() {
        table.render({
            elem: '#demo'
            , url: '/system/account/getAccountByPage' //数据接口
            , toolbar: '#toolbarDemo' //添加头部工具栏
            , title: '用户数据表'
            , cols: [
                [ //表头
                    {type: 'checkbox'}
                    , {field: 'id', title: 'ID', sort: true, width: 40, hide: true}
                    , {field: 'username', title: '用户名', width: 120}
                    , {
                    field: 'roleId', title: '角色名称', width: 120, templet: function (data) {
                        return data.roleName;
                    }
                }
                    , {field: 'email', title: '邮箱', width: 180}
                    , {field: 'phone', title: '电话', width: 130}
                    , {field: 'address', title: '地址'}
                    , {field: 'createTime', title: '创建时间', width: 160}
                    , {field: 'sex', title: '性别', templet: '#switchTpl', width: 80}
                    , {field: 'status', title: '状态', templet: '#checkboxTpl', width: 110}
                    , {field: 'description', title: '描述'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 200}
                ]
            ]
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                , groups: 4 //只显示 4 个连续页码
                , first: false //不显示首页
                , last: false //不显示尾页
            }
        })
    }

    /**
     * 添加及修改操作
     * @param data
     */
    function addOrEdit(data) {
        $.ajax({
            url: "/system/account/addOrEdit"
            , data: data
            , async: false
            , type: "post"
            , dataType: "json"
            , success: function (data) {
                if (data.success) {
                    layer.msg(data.msg, {icon: 1});
                } else {
                    layer.msg(data.msg, {icon: 2});
                }
            }
        });
        tableInit();
    }

    /**加载角色数据*/
    function getRole() {
        $.ajax({
            url: "/system/role/getRoles/"
            , async: false
            , type: "post"
            , dataType: "json"
            , success: function (data) {
                var roleData = data.data;
                document.getElementById("role").innerHTML = "";
                $("#testlayer #role").append("<option value=''>" + "请选择" + "</option>");
                for (var i = 0; i < roleData.length; i++) {
                    $("#testlayer #role").append("<option value=" + roleData[i].id + ">" + roleData[i].name + "</option>");
                }
            }
        });
    }

    /**添加和编辑弹出框*/
    function openForm(data) {
        getRole();
        if (data == null) {
            $("#testlayer #pwd").removeClass("layui-hide");
            document.getElementById("pw").setAttribute("lay-verify", "required");
        } else {
            $("#testlayer #pwd").addClass("layui-hide");
            console.log("afafa:" + data.status)
            console.log(data)
            document.getElementById("pw").setAttribute("lay-verify", "");
            $("#testlayer").find("input[name='id']").val(data.id);
            $("#testlayer").find("input[name='username']").val(data.username);
            $("#testlayer").find("input[name='phone']").val(data.phone);
            $("#testlayer").find("input[name='email']").val(data.email);
            $("#testlayer").find("input[name='status']")[0].checked = data.status;
            $("#testlayer").find("input[name='address']").val(data.address);
            $("#testlayer").find("input[data-id='" + data.sex + "']")[0].checked = true;
            $("#testlayer").find("select[name='roleId']").val(data.roleId);
            $("#testlayer").find("textarea[name='description']").val(data.description);
        }
        $("#testlayer").removeClass("layui-hide");
        form.render();
        //打开编辑框
        layer.open({
            type: 1,
            skin: 'layui-layer-molv',
            title: '用户信息',
            shadeClose: false,
            shade: 0.3,
            offset: 't',
            area: ['auto', 'auto'],
            content: $("#testlayer"),
            cancel: function (index, layero) {
                document.getElementById("testlayer").reset();
                $("#testlayer").addClass("layui-hide");
            }
        });
    };

    /**
     * 批量删除
     * @param ids
     */
    function delBatch(ids) {
        $.ajax({
            url: "/system/account/delBatch/"
            , async: false
            , type: "post"
            , data: {"ids": ids}
            , dataType: "json"
            , success: function (data) {
                if (data.success) {
                    layer.msg(data.msg, {icon: 1});
                } else {
                    layer.msg(data.msg, {icon: 2});
                }
            }
        });
        tableInit();
    }


});



