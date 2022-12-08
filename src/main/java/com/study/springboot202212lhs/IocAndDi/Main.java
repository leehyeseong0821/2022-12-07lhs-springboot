package com.study.springboot202212lhs.IocAndDi;


public class Main {

    private final UserService userService;

    public Main(UserService userService){
//        this.userService = UserServiceImp.getInstance(); //이것이 생성된다 일체형 우리는 객체지향 개발을 해야한다. 별개로 가야함 매개변수로 서비스를 받아야함
        this.userService = userService;
    }

    public void run(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args){
        UserService userService = UserServiceImp.getInstance();
                        //위에 userservice를 아래에 주입했다 의존주입성 DI
        Main main = new Main(userService); //이것을 생성해야
        main.run();

    }

}
