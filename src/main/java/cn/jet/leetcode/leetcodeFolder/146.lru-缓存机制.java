/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (52.63%)
 * Likes:    1564
 * Dislikes: 0
 * Total Accepted:    212.3K
 * Total Submissions: 403.5K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 
 * 
 * 
 * 实现 LRUCache 类：
 * 
 * 
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)
 * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 
 * 
 * 
 * 
 * 
 * 
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 0 
 * 最多调用 2 * 10^5 次 get 和 put
 * 
 * 
 */

// @lc code=start
class LRUCache {

    private final int MAX_CAPACITY = 3000;

        private final int MIN_CAPACITY = 1;

        private int count = 0;

        private int capacity = 0;

        private volatile int MAX_TERM = 0;

        private volatile int MIN_TERM_INDEX = 0;

        private Node[] cache;

        class Node {
            int key;
            int value;
            int term;
        }

        public LRUCache(int capacity) {
            if (capacity < MIN_CAPACITY) {
                capacity = MIN_CAPACITY;
            } else if (capacity > MAX_CAPACITY) {
                capacity = MAX_CAPACITY;
            }
            this.capacity = capacity;
            cache = new Node[capacity];
        }

        public int get (int key) {
            if (cache == null) return -1;
            for (int i = 0; i < count; i++) {
                Node node = cache[i];
                if (node == null) continue;
                if (node.key == key) {
                    MAX_TERM++;
                    node.term = MAX_TERM;
                    if (i == MIN_TERM_INDEX) {
                        resetMinTerm(i);
                    }
                    return node.value;
                }
            }
            return -1;
        }

        public void put (int key, int value) {
            if (cache == null) return;
            for (int i = 0; i < count; i++) {
                Node node = cache[i];
                if (node == null) continue;
                if (node.key == key) {
                    MAX_TERM++;
                    node.term = MAX_TERM;
                    if (i == MIN_TERM_INDEX) {
                        resetMinTerm(i);
                    }
                    node.value = value;
                    return;
                }
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.term = ++MAX_TERM;

            if (count < capacity)  {
                cache[count] = node;
                count++;
                MIN_TERM_INDEX = 0;
            } else {
                cache[MIN_TERM_INDEX] = node;
                resetMinTerm(MIN_TERM_INDEX);
            }
        }

        private void resetMinTerm(int skipIndex) {
            int minIndexTemp = -1;
            int minTermTemp = -1;
            for (int i = 0; i < count; i++) {
                Node node = cache[i];
                if (node == null) continue;
                if (i == skipIndex) continue;
                if (minTermTemp != -1 && node.term > minTermTemp) continue;
                minIndexTemp = i;
                minTermTemp = node.term;
            }
            if (minIndexTemp != -1) MIN_TERM_INDEX = minIndexTemp;
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

