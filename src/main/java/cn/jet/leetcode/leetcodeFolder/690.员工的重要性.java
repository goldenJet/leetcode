/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Employee employee = map.get(id);
        int sum = employee.importance;
        sum += sumImportance(employee, map);
        return sum;
    }
    public static int sumImportance(Employee e, Map<Integer, Employee> map) {
        int sum = 0;
        if (e != null && e.subordinates != null && e.subordinates.size() > 0) {
            for (Integer subordinate : e.subordinates) {
                if (map.containsKey(subordinate)) {
                    sum += map.get(subordinate).importance;
                    sum += sumImportance(map.get(subordinate), map);
                }
            }
        }
        return sum;
    }
}
// @lc code=end

