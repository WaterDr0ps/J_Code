function Sum(x) {
    let sum = 0;
    for(let i=0;i<=x;i++){
        sum+=i;
    }
    document.log(sum);
}

function change(x) {
    switch (x) {
        case 0:
            document.write("星期日");
            break;
        case 1:
            document.write("星期一");
            break;
        case 2:
            document.write("星期二");
            break;
        case 3:
            document.write("星期三");
            break;
        case 4:
            document.write("星期四");
            break;
        case 5:
            document.write("星期五");
            break;
        case 6:
            document.write("星期六");
            break;
        default:
            document.write("输入有误");
    }
}
