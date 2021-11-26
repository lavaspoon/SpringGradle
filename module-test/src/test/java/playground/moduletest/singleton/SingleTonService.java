package playground.moduletest.singleton;

public class SingleTonService {
    // 자기 자신을 static 으로 내부에 선언해 객체 생성 → 클래스 레벨에서 인스턴스를 하나만 가지게 된다.
    private static SingleTonService instance = new SingleTonService();
    // public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingleTonService getInstance() {
        return instance;
    }
    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingleTonService(){
    }
}
