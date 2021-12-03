package chap11.playlist;

/*
 * 3. 부모 클래스와 자식 클래스의 동시 수정 문제는 해결 x
 *
 * 기존 문제는 부모(Playlist)에 singers track이 추가됨에 따라 자식 클래스에서도 수정이 발생한다는 문제였다.
 * 안타깝게도 remove에서 보이는 것처럼, singers track에 대한 remove 처리를 자식에서 해줘야 한다.
 *
 * append 처럼 부모로 옮기면 안되나? : No, 이 행동은 클라이언트(나)가 Playlist 코드를 직접 수정해서 얻은 것이다. 불가능하다고 가정하자.
 * 즉, 앞서 상속 -> 합성으로 변경하는 과정에서 부모 코드를 직접 변경해서는 안된다.
 * 따라서 PersonalPlaylist에서의 합성은 이 문제를 해결할 수 없다.
 */

public class PersonalPlaylist {
    private Playlist playlist = new Playlist();

    public void append(Song song) {
        playlist.append(song);
    }

    public void remove(Song song) {
        playlist.getTracks().remove(song);
        playlist.getSingers().remove(song.getSinger());
        // playlist.remove(song); // 이 행동은 클라이언트(나)가 Playlist 코드를 직접 수정해서 얻은 것이다.
    }
}
