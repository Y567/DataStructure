package 贪心;

public class 跳跃游戏 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例 1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例 2:
     *
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 跳跃数组
     * @return 返回一个布尔值
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return true;
        }
        int[] index = new int[nums.length];
        //1.0 计算跳远的最远位置
        for (int i = 0; i < nums.length; i++) {
            index[i] = i + nums[i];
        }
        //2.0设置变量，进行扫描index数组
        int jump = 0;
        //最远可跳的位置，初始值为index[0]
        int max_index = index[0];
        for (jump = 0; jump < index.length; jump++) {
            if(jump > max_index){
                //说明跳到了自己不能跳的位置，失败
                return false;
            }
            if(index[jump] > max_index){
                max_index = index[jump];
            }
        }
        return true;
    }
}
