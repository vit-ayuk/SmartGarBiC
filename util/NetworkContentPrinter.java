package util;


import java.util.Collection;
import java.util.List;

import util.NetworkContentPrinter;

import core.Content;
import core.ContentType;
import core.DTNHost;
import core.Message;
import core.Settings;
import core.SimClock;
import core.SimScenario;


public class NetworkContentPrinter {

    public static void printNodeContents(List<DTNHost> nodes) {
        for (DTNHost node : nodes) {
            System.out.println("Node: " + node.getAddress());
            Collection<Content> contentStore = node.getRouter().getContentStore();

            if (contentStore.isEmpty()) {
                System.out.println("  No content in this node.");
            } else {
                for (Content content : contentStore) {
                    System.out.println("  Content ID: " + content.getContentId() +
                                       ", Type: " + content.getContentType() +
                                       ", Size: " + content.getSize() +
                                       ", Creation Time: " + content.getContentTimeOfCreation());
                }
            }
        }
    }
}
