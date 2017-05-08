package com.exer.reserve_manager.tester;

import com.exer.reserve_manager.state.State;
import com.exer.reserve_manager.state.ViewOfConference;

public class ViewOfConfTester {

    public static void main(String[] args) {

        State state = new ViewOfConference();

        state.view();
    }

}
