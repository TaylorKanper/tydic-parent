<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="20" <if condition="$Think.session.pageSize eq 20">selected="selected"</if>>20</option>
                <option value="40" <if condition="$Think.session.pageSize eq 40">selected="selected"</if>>40</option>
                <option value="60" <if condition="$Think.session.pageSize eq 60">selected="selected"</if>>60</option>
                <option value="120" <if condition="$Think.session.pageSize eq 120">selected="selected"</if>>120</option>
                <option value="150" <if condition="$Think.session.pageSize eq 150">selected="selected"</if>>150</option>
            </select>
        </div>
        <span>条，共 {$total} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="{$total}" data-page-size="1" data-page-current="{$Think.session.pageCurrent}">
    </div>
</div>

<script>
    /* zxc优化开始 */

    // 解决多个列表间的排序冲突问题
    $("[name='orderField']:last").val("");
    $("[name='orderDirection']:last").val("");

    // 解决多个列表间的分页不同步问题
    var selectedPagesize = $('.selectPagesize:last > select').val();
    $("[name='pageSize']:last").val(selectedPagesize);
    $(".pagination-box").attr('data-page-size',selectedPagesize);   

    console.log("pageSize:" + $("[name='pageSize']:last").val());
    console.log("selectedPagesize:" + selectedPagesize);
    console.log("data-page-size:" + $(".pagination-box").attr('data-page-size'));

    /* zxc优化结束 */
</script>