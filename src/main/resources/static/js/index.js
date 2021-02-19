

    function check1() {
        var memberName = $("#memberName").val();
        var memberEmail = $("#memberEmail").val();
        var affiliation = $("#affiliation").val();
        var country = $("#country").val();
        if (isEmpty(memberName)) {
            alert("输入用户姓名");
            return false;
        } else if (isEmpty(memberEmail)) {
            alert("输入邮箱");
            return false;
        } else if (isEmpty(affiliation)) {
            alert("输入组织");
            return false;
        } else if (isEmpty(country)) {
            alert("输入国别");
            return false;
        }
        else if(!isEmail(memberEmail)){
            alert("请输入正确的邮箱格式");
            return false;
        }

        return true;
    }

    function isEmail(str) {
        if (!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(str)) {
            return false; }
        else {
            return true;}
    }

    function isEmpty(str) {
        if (str == null || str.trim() == "")
            return 1;
        return 0;
    }
  function check2(){

      var find_value=$("#find-value").val();
      if(isEmpty(find_value)){
          alert("输入查询值");
          return false;
      }
      return true;
  }

  function check3(){
    if(isEmpty($("#deleteId").val())){
        alert("输入需要删除的会员Id");
        return false;
    }
    return true;
  }


















 


