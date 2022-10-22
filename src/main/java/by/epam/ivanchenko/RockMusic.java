package by.epam.ivanchenko;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    private List<String> rockMusicList = new ArrayList<>();

    {
        rockMusicList.add("Rammstein");
        rockMusicList.add("Scorpions");
        rockMusicList.add("Kiss");
    }

    @Override
    public List<String> getSong() {
     return rockMusicList;
    }


}
