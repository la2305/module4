package com.example.songapplication.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String nameSinger;
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String song, String nameSinger, String type) {
        this.id = id;
        this.name = song;
        this.nameSinger = nameSinger;
        this.type = type;
    }

    public SongDto(String song, String nameSinger, String type) {
        this.name = song;
        this.nameSinger = nameSinger;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().equals("")){
            errors.rejectValue("name",null,"Không để trống tên bài hát");
        } else if (songDto.getName().length()>800) {
            errors.rejectValue("name",null,"Tên không được vượt quá 800 kí tự");
        }else if (songDto.getName().matches("^[^<>{}\\\"/|;:.,~!?@#$%^=&*\\\\]\\\\\\\\()\\\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$")){
            errors.rejectValue("name",null,"tên không chứa kí tự đặc biệt nhé");
        }
        if (songDto.getNameSinger().equals("")){
            errors.rejectValue("nameSinger",null,"Không để trống tên ca sĩ");
        } else if (songDto.getName().length()>300) {
            errors.rejectValue("nameSinger",null,"Tên không được vượt quá 300 kí tự");
        }else if (songDto.getName().matches("^[^<>{}\\\"/|;:.,~!?@#$%^=&*\\\\]\\\\\\\\()\\\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$")){
            errors.rejectValue("nameSinger",null,"tên không chứa kí tự đặc biệt nhé");
        }
        if (songDto.getType().equals("")){
            errors.rejectValue("name",null,"Không để trống thể loại nhạc");
        } else if (songDto.getType().length()>1000) {
            errors.rejectValue("name",null,"Tên không được vượt quá 1000 kí tự");
        }else if (songDto.getType().matches("^[^<>{}\\\"/|;:.~!?@#$%^=&*\\\\]\\\\\\\\()\\\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$")){
            errors.rejectValue("name",null,"tên không chứa kí tự đặc biệt nhé, có thể chấp nhận dấu ,");
        }
    }
}
