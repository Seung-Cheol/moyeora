package moyeora.myapp.service.impl;

import lombok.RequiredArgsConstructor;
import moyeora.myapp.dao.ChatDao;
import moyeora.myapp.vo.Dm;
import moyeora.myapp.vo.DmRoom;
import moyeora.myapp.vo.Gm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DefaultChatService {

    private final ChatDao chatDao;
    private final DefaultNotificationService notificationService;

    @Transactional
    public void saveGm(Gm gm) throws Exception {
        chatDao.saveGm(gm);
    }

    public Gm getGm(int no) {
        return chatDao.getGm(no);
    }

    public void saveDm(Dm dm) {
        chatDao.saveDm(dm);
    }

    public Dm getDm(int no) {
        return chatDao.getDm(no);
    }

    public List<Gm> getGmList(int no) {
        return chatDao.findGmListBySchoolNo(no);
    }

    public List<Dm> getDmList(int sender, int receiver) {
        return chatDao.findDmListBySenderAndReceiver(sender,receiver);
    }

    public List<Dm> getDmList(int no) {
        return chatDao.findDmListByRoomNo(no);
    }

    public void addDmRoom(DmRoom room) {
        chatDao.addDmRoom(room);
    }

    public DmRoom getDmRoom(int no) {
        return chatDao.findDmRoomByNo(no);
    }

    public DmRoom getDmRoom(int sender, int receiver) {
        return chatDao.findDmRoomByUserNo(sender,receiver);
    }

    public List<Gm> getGmListOnlyLast(int no) {
        return chatDao.getGmListOnlyLast(no);
    }

    public List<Dm> getDmListOnlyLast(int no) {
        return chatDao.getDmListOnlyLast(no);
    }
}
