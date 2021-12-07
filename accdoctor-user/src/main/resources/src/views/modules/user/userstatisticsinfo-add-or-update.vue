<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="会员id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="会员id"></el-input>
    </el-form-item>
    <el-form-item label="累计消费金额" prop="consumeAmount">
      <el-input v-model="dataForm.consumeAmount" placeholder="累计消费金额"></el-input>
    </el-form-item>
    <el-form-item label="订单数量" prop="orderCount">
      <el-input v-model="dataForm.orderCount" placeholder="订单数量"></el-input>
    </el-form-item>
    <el-form-item label="评价数" prop="commentCount">
      <el-input v-model="dataForm.commentCount" placeholder="评价数"></el-input>
    </el-form-item>
    <el-form-item label="退货数量" prop="returnOrderCount">
      <el-input v-model="dataForm.returnOrderCount" placeholder="退货数量"></el-input>
    </el-form-item>
    <el-form-item label="登录次数" prop="loginCount">
      <el-input v-model="dataForm.loginCount" placeholder="登录次数"></el-input>
    </el-form-item>
    <el-form-item label="关注数量" prop="attendCount">
      <el-input v-model="dataForm.attendCount" placeholder="关注数量"></el-input>
    </el-form-item>
    <el-form-item label="关注的陪诊员数量" prop="attendFellowCount">
      <el-input v-model="dataForm.attendFellowCount" placeholder="关注的陪诊员数量"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userId: '',
          consumeAmount: '',
          orderCount: '',
          commentCount: '',
          returnOrderCount: '',
          loginCount: '',
          attendCount: '',
          attendFellowCount: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '会员id不能为空', trigger: 'blur' }
          ],
          consumeAmount: [
            { required: true, message: '累计消费金额不能为空', trigger: 'blur' }
          ],
          orderCount: [
            { required: true, message: '订单数量不能为空', trigger: 'blur' }
          ],
          commentCount: [
            { required: true, message: '评价数不能为空', trigger: 'blur' }
          ],
          returnOrderCount: [
            { required: true, message: '退货数量不能为空', trigger: 'blur' }
          ],
          loginCount: [
            { required: true, message: '登录次数不能为空', trigger: 'blur' }
          ],
          attendCount: [
            { required: true, message: '关注数量不能为空', trigger: 'blur' }
          ],
          attendFellowCount: [
            { required: true, message: '关注的陪诊员数量不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/user/userstatisticsinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.userStatisticsInfo.userId
                this.dataForm.consumeAmount = data.userStatisticsInfo.consumeAmount
                this.dataForm.orderCount = data.userStatisticsInfo.orderCount
                this.dataForm.commentCount = data.userStatisticsInfo.commentCount
                this.dataForm.returnOrderCount = data.userStatisticsInfo.returnOrderCount
                this.dataForm.loginCount = data.userStatisticsInfo.loginCount
                this.dataForm.attendCount = data.userStatisticsInfo.attendCount
                this.dataForm.attendFellowCount = data.userStatisticsInfo.attendFellowCount
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/user/userstatisticsinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'consumeAmount': this.dataForm.consumeAmount,
                'orderCount': this.dataForm.orderCount,
                'commentCount': this.dataForm.commentCount,
                'returnOrderCount': this.dataForm.returnOrderCount,
                'loginCount': this.dataForm.loginCount,
                'attendCount': this.dataForm.attendCount,
                'attendFellowCount': this.dataForm.attendFellowCount
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
