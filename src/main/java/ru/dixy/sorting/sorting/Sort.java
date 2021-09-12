package ru.dixy.sorting.sorting;

import java.util.*;

public class Sort {

        public List<String> sortDesc(String[] data) {
            Set<String> unique = new HashSet<>(Arrays.asList(data));
            addParents(unique, data);
            List<String> result = new ArrayList<>(unique);
            result.sort((o1, o2) -> {
                                        int res = 0;
                                        char[] first = o1.toCharArray();
                                        char[] second = o2.toCharArray();
                                        int i = 0, j = 0;
                                        while (i < first.length && j < second.length) {
                                            char ch1 = first[i++];
                                            char ch2 = second[j++];
                                            if (ch1 != ch2) {
                                                res = ch1 > ch2 ? -1 : 1;
                                                break;
                                            }
                                        }
                                        if (res == 0) {
                                            if (i < first.length) {
                                                res = 1;
                                            } else if (j < second.length) {
                                                res = -1;
                                            }
                                        }
                                        return res;
                                    });
            return result;
        }

        private void addParents(Set<String> result, String[] data) {
            Arrays.stream(data)
                    .forEach(str -> this.addParent(str, result));
        }

        private void addParent(String str, Set<String> result) {
            int index = str.lastIndexOf('\\');
            while (index != -1) {
                String parent = str.substring(0, index);
                result.add(parent);
                index = parent.lastIndexOf('\\');
            }
        }
}

