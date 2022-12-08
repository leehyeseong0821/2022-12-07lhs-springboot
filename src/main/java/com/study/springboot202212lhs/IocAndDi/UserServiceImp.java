package com.study.springboot202212lhs.IocAndDi;

public class UserServiceImp implements UserService{

    //싱글톤
    private static UserServiceImp instance = null;
    private UserServiceImp (){}
    public static UserServiceImp getInstance(){
        if(instance==null){
            instance = new UserServiceImp();
        }
        return instance;
    }


    @Override
    public void createUser() {
        System.out.println("사용자 등록");
    }

    @Override
    public void getUser() {
        System.out.println("사용자 조회");
    }

    @Override
    public void updateUser() {
        System.out.println("사용자 수정");
    }

    @Override
    public void deleteUser() {
        System.out.println("사용자 삭제");
    }
}
