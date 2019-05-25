package com.example.asus.ChannelPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2019/5/7.
 */

class ChannelLab{
    private static ChannelLab instance = null;
    private List<String> movie;
    private List<String> url;
    private List<String> list;

    private ChannelLab() {
        init();
    }

    public static ChannelLab get() {
        if (null == instance) {
            instance = new ChannelLab();
        }
        return instance;

    }

    public int getSize() {
        return movie.size();

    }

    public String getMovie(int n) {
        return movie.get(n);
    }

    public String getUrl(int n) {
        return url.get(n);
    }

    private void chaifen() {
        int n = 0;

        for (String i : list) {
            String[] tmp = i.split(",");
            movie.add(tmp[0]);
            url.add(tmp[1]);

        }

    }


    private void init() {
        movie = new ArrayList<>();
        url = new ArrayList<>();
        list = new ArrayList<>();
        list.add("CCTV4,http://ivi.bupt.edu.cn/hls/cctv4.m3u8");
        list.add("四川文化,http://scgctvshow.sctv.com/hdlive/sctv2/3.m3u8");
        list.add("四川经济,http://scgctvshow.sctv.com/hdlive/sctv3/3.m3u8");
        list.add("四川影视,http://scgctvshow.sctv.com/hdlive/sctv5/3.m3u8");
        list.add("四川妇女,http://scgctvshow.sctv.com/hdlive/sctv7/3.m3u8");
        list.add("四川公共,http://scgctvshow.sctv.com/sdlive/sctv9/3.m3u8");
        list.add("峨眉电影,http://scgctvshow.sctv.com/hdlive/emei/3.m3u8");
        list.add("北京怀柔1套,http://live.huairtv.com:1935/dvrLive/hrtvmb/playlist.m3u8");
        list.add("峨眉电影,http://scgctvshow.sctv.com/hdlive/emei/3.m3u8");
        list.add("济南影视,http://ts1.ijntv.cn/yshd/hd/live.m3u8");

        chaifen();
    }
}

