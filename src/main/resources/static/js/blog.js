/**获取博客标签云*/
function getBlogTags() {
    $.ajax({
        url: "blog/getBlogTags"
        , async: false
        , type: "get"
        , success: function (data) {
            var html = "";
            var results = data.data;
            for (var i = 0; i < results.length; i++) {
                console.log(results[i])
                html +=  "<a href='javascript:;' onclick='getBlogByCreateTime(this)'>"+results[i]+"</a>"
            }
            $("#cloud").append(html);
        }
    })
}

/**获取置顶的文章信息*/
function getTop() {
    $.ajax({
        url: "/blog/getBlogTop"
        , async: false
        , type: "get"
        ,success:function (data) {
            var html = "";
            var results = data.data;
            html += " <ul>";
            for (var i = 0; i < results.length; i++) {
                var d = results[i];
                html += "<li><b>";
                html += "<a href='javascript:;' onclick=\"getCount('" + d.url + "','" + d.id + "')\">" + d.title + "</a></b>";
                html += "<p>"+d.abs+"</p></li>"
            }
            html += "</ul>"
            $("#zhiding").append(html);
        }
    })
}


/**点击文章链接后，文章浏览次数加1*/
function getCount(url, id) {
    window.location.href = url;
    $.ajax({
        url: "/setCount"
        , async: false
        , type: "post"
        , data: {id: id}
    })
}


/**点击文章链接后，文章浏览次数加1*/
function getFriends() {
    $.ajax({
        url: "/friends/getAll"
        , async: false
        , type: "post"
        , success :function (data) {
            var html = "";
            var results = data.data;
            html += " <ul>";
            for (var i = 0; i < results.length; i++) {
                var d = results[i];
                html += "<li>";
                html += "<a href='"+d.url+"'>" + d.title + "</a>";
            }
            html += "</ul>"
            $(".links").append(html);
        }
    })
}