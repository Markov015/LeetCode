class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> m;
        map<int, int>::const_iterator it;
        for(int i = 0; i < nums.size(); i++){
            int implement = target - nums[i];
            it = m.find(implement);
            if(it != m.end() && it->second != i){
                vector<int> res;
                res.push_back(i);
                res.push_back(it->second);
                sort(res.begin(),res.end());
                return res;
            }else{
                m[nums[i]] = i;
            }
        }
    }
};
