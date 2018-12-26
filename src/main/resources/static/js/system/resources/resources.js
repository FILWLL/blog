layui.config({
    base: '/plugin/layui-v2.4.5/model/',
})
layui.use(['treetable', 'form', 'layer', 'tree'], function () {
    var treetable = layui.treetable,
        form = layui.form,
        layer = layui.layer;
    var $ = layui.jquery, tree = layui.tree;
    var data1 = null;
    /**
     * 初始化树形表格
     */
    treetableInit();
    treeinput();
    //监听表格添加
    treetable.on('treetable(add)', function (data) {
        layer.msg('添加操作');
        console.dir(data);
    })
    //监听表格编辑
    treetable.on('treetable(edit)', function (data) {
        layer.msg('编辑操作');
        console.dir(data);
    })

    //编辑框下拉树点击事件
    $(".downpanel").on("click", ".layui-select-title", function (e) {
        $(".layui-form-select").not($(this).parents(".layui-form-select")).removeClass("layui-form-selected");
        $(this).parents(".downpanel").toggleClass("layui-form-selected");
        layui.stope(e);
    }).on("click", "dl i", function (e) {
        layui.stope(e);
    });
    $(document).on("click", function (e) {
        $(".layui-form-select").removeClass("layui-form-selected");
    });


    $('.up-all').click(function () {
        treetable.all('up');
    })

    $('.down-all').click(function () {
        treetable.all('down');

    })

    //添加菜单事件
    $('.add-menu').click(function () {
        //加载编辑框的菜单树

        //打开编辑框
        $("#testlayer").removeClass("layui-hide");
        layer.open({
            type: 1,
            skin: 'layui-layer-molv',
            title: '用户信息',
            shadeClose: true,
            shade: 0.3,
            offset: 't',
            area: ['auto', 'auto'],
            content: $("#testlayer"),
            cancel: function (index, layero) {
                document.getElementById("testlayer").reset();
                $("#testlayer").addClass("layui-hide");
            }
        });
    });
    //监听编辑框的提交事件
    form.on('submit(formDemo)', function (data) {
        console.log(data.field);
        $.ajax({
            url: "/system/resources/addOrEdit"
            , data: data.field
            , async: false
            , type: "post"
            , dataType: "json"
            , success: function (data) {
                document.getElementById("testlayer").reset();
                $("#testlayer").addClass("layui-hide");
                treetableInit();
                layer.closeAll('page');
                if (data.success) {
                    layer.msg(data.msg);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    });

    form.on('switch(status)', function (data) {
        layer.msg('监听状态操作');
        console.dir(data);
    });




    function treeinput() {
        //获取菜单资源
        $.ajax({
            url: "/system/resources/getResourcesTree",
            method: 'POST',
            async: false,
            success: function (results) {
                data1 = results.data;
            }
        });
        tree({
            elem: "#classtree"
            , nodes: data1
            , click: function (node) {
                var $select = $($(this)[0].elem).parents(".layui-form-select");
                $select.removeClass("layui-form-selected").find(".layui-select-title span").html(node.name).end().find("input:hidden[name='pid']").val(node.id);
            }
        });
    }

    function treetableInit() {
        //获取菜单资源
        $.ajax({
            url: "/system/resources/getAllResources",
            method: 'POST',
            async: false,
            success: function (results) {
                data1 = results.data;
            }
        });
        treetable.render({
            elem: '#test-tree-table',
            data: data1,
            field: 'name',
            is_checkbox: true,
            cols: [
                {
                    field: 'name',
                    title: '标题',
                    width: '15%',
                },
                {
                    field: 'id',
                    title: 'ID',
                    width: '3%'
                },
                {
                    field: 'pid',
                    title: '父ID',
                    width: '4%',
                },
                {
                    field: 'type',
                    title: '类型',
                    width: '5%',
                    template: function (item) {
                        if (item.type == 0) {
                            return '目录';
                        }
                        if (item.type == 1) {
                            return '菜单';
                        }
                        if (item.type == 2) {
                            return '按钮';
                        }
                        return '其他';
                    }
                },
                {
                    field: 'resourceUrl',
                    title: '资源路径',
                    width: '10%',
                    template: function (item) {
                        if (item.resourceUrl == null) {
                            return '';
                        }
                        return item.resourceUrl;
                    }
                },
                {
                    field: 'perms',
                    title: '权限',
                    width: '10%',
                    template: function (item) {
                        if (item.perms == null) {
                            return '';
                        }
                        return item.perms;
                    }
                },
                {
                    field: 'locked',
                    title: '状态',
                    width: '6%',
                    template: function (item) {
                        if (item.locked == 0) {
                            return '<input type="checkbox" name="locked"lay-skin="switch" lay-filter="status" lay-text="正常|禁用" checked>';
                        }
                        return '<input type="checkbox" name="locked" lay-skin="switch" lay-filter="status" lay-text="正常|禁用" >';
                    }
                },
                {
                    field: 'description',
                    title: '功能介绍',
                    width: '20%',
                    template: function (item) {
                        if (item.description == null) {
                            return '暂无介绍';
                        }
                        return item.description;
                    }
                },
                {
                    field: 'actions',
                    title: '操作',
                    width: '20%',
                    template: function (item) {
                        var tem = [];
                        if (item.pid == 0) {
                            tem.push('<a class="add-child" lay-filter="add">添加子级</a>');
                        }
                        tem.push('<a lay-filter="edit">编辑</a>');
                        if (item.pid > 0) {
                            tem.push('<a class="set-attr">设置属性</a>');
                        }
                        return tem.join(' <font>|</font> ')
                    },
                },
            ]
        });
    }
})


