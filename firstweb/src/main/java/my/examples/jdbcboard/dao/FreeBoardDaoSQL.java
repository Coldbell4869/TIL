package my.examples.jdbcboard.dao;

public class FreeBoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT id, uid, user_name, title, content, regdate, readcount, family, level, sequence FROM freepost LEFT JOIN user ON user.user_name = freepost.uname WHERE id =?";
// select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth, content from board where id = ? // urstory
// SELECT f.post_id, f.title, u.nickname, f.content, f.regdate, f.view,f.fam_num, f.fam_lev, f.fam_seq, u.user_id FROM freepost f LEFT JOIN user u ON f.nickname = u.nickname WHERE f.post_id=?" // irerin07
    public static final String SELECT_BY_PAGING =
            "SELECT id, uid, user_name, title, regdate, readcount, family, level, sequence FROM freepost LEFT JOIN user ON user.user_name = freepost.uname ORDER BY id DESC LIMIT ?, ?";
// "select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth  from board b order by group_no desc, group_seq limit ?, ?"; // urstory
// "SELECT f.post_id, f.title, u.nickname, f.content, f.regdate, f.view,f.fam_num, f.fam_lev, f.fam_seq, u.user_id FROM freepost f LEFT JOIN user u ON f.nickname = u.nickname ORDER BY f.post_id DESC LIMIT ?, ?"; // irerin07

    public static final String INSERT =
            "INSERT INTO freepost(uid, uname, title, content, family, sequence, level) VALUES(?, ?, ?, ?, 1, 1, 1)";
//    insert into board (title, user_id, nickname, content, group_no, group_seq, group_depth) " +
//            "values( ?, ?, ?, ? ,  0 , 0, 0 );"
    public static final String SELECT_LAST_INSERT_ID =
            "SELECT LAST_INSERT_ID()";    // MySQL의 기능임. 가장 마지막에 insert된 id를 가져옴. 가장 최근에 성공적으로 수행된 INSERT 구문의 첫번째 AUTO_INCREMENT column의 값을 반환한다.
    public static final String UPDATE_LAST_INSERT_ID =
            "UPDATE freepost SET family = ? where id =?";
    public static final String UPDATE =
            "UPDATE freepost SET readcount = readcount + 1 WHERE id = ?";
    public static final String DELETE =
            "DELETE FROM freepost WHERE id = ?";
    public static final String UPDATE_GROUP_SEQ_GT =
            "UPDATE freepost SET sequence = sequence + 1 WHERE family = ? and sequence > ?";
    public static final String INSERT_RE =
            "INSERT INTO freepost (uid, uname, title, content, family, sequence, level) " +
                    "values( ?, ?, ?, ? ,  ? , ?, ? )";
}
