package server.api.demo.domain;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ListData {

    List<BoardEntity> responesList = new ArrayList<>();
}
