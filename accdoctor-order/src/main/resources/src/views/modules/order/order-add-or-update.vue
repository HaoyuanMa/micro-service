<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="member_id" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder="member_id"></el-input>
    </el-form-item>
    <el-form-item label="订单号" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder="订单号"></el-input>
    </el-form-item>
    <el-form-item label="create_time" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="create_time"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="userUsername">
      <el-input v-model="dataForm.userUsername" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="订单总额" prop="totalAmount">
      <el-input v-model="dataForm.totalAmount" placeholder="订单总额"></el-input>
    </el-form-item>
    <el-form-item label="应付总额" prop="payAmount">
      <el-input v-model="dataForm.payAmount" placeholder="应付总额"></el-input>
    </el-form-item>
    <el-form-item label="支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】" prop="payType">
      <el-input v-model="dataForm.payType" placeholder="支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】"></el-input>
    </el-form-item>
    <el-form-item label="订单来源[0->PC订单；1->app订单]" prop="sourceType">
      <el-input v-model="dataForm.sourceType" placeholder="订单来源[0->PC订单；1->app订单]"></el-input>
    </el-form-item>
    <el-form-item label="订单状态【0->待付款；1->待接单；2->已接单；3->已完成；4->已关闭；5->无效订单】" prop="status">
      <el-input v-model="dataForm.status" placeholder="订单状态【0->待付款；1->待接单；2->已接单；3->已完成；4->已关闭；5->无效订单】"></el-input>
    </el-form-item>
    <el-form-item label="用户姓名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户姓名"></el-input>
    </el-form-item>
    <el-form-item label="用户电话" prop="userPhone">
      <el-input v-model="dataForm.userPhone" placeholder="用户电话"></el-input>
    </el-form-item>
    <el-form-item label="省份/直辖市" prop="userProvince">
      <el-input v-model="dataForm.userProvince" placeholder="省份/直辖市"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="userCity">
      <el-input v-model="dataForm.userCity" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="区" prop="userRegion">
      <el-input v-model="dataForm.userRegion" placeholder="区"></el-input>
    </el-form-item>
    <el-form-item label="详细地址" prop="userDetailAddress">
      <el-input v-model="dataForm.userDetailAddress" placeholder="详细地址"></el-input>
    </el-form-item>
    <el-form-item label="订单备注" prop="note">
      <el-input v-model="dataForm.note" placeholder="订单备注"></el-input>
    </el-form-item>
    <el-form-item label="删除状态【0->未删除；1->已删除】" prop="deleteStatus">
      <el-input v-model="dataForm.deleteStatus" placeholder="删除状态【0->未删除；1->已删除】"></el-input>
    </el-form-item>
    <el-form-item label="支付时间" prop="paymentTime">
      <el-input v-model="dataForm.paymentTime" placeholder="支付时间"></el-input>
    </el-form-item>
    <el-form-item label="接单时间" prop="deliveryTime">
      <el-input v-model="dataForm.deliveryTime" placeholder="接单时间"></el-input>
    </el-form-item>
    <el-form-item label="结单时间" prop="finishTime">
      <el-input v-model="dataForm.finishTime" placeholder="结单时间"></el-input>
    </el-form-item>
    <el-form-item label="评价时间" prop="commentTime">
      <el-input v-model="dataForm.commentTime" placeholder="评价时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="modifyTime">
      <el-input v-model="dataForm.modifyTime" placeholder="修改时间"></el-input>
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
          memberId: '',
          orderSn: '',
          createTime: '',
          userUsername: '',
          totalAmount: '',
          payAmount: '',
          payType: '',
          sourceType: '',
          status: '',
          userName: '',
          userPhone: '',
          userProvince: '',
          userCity: '',
          userRegion: '',
          userDetailAddress: '',
          note: '',
          deleteStatus: '',
          paymentTime: '',
          deliveryTime: '',
          finishTime: '',
          commentTime: '',
          modifyTime: ''
        },
        dataRule: {
          memberId: [
            { required: true, message: 'member_id不能为空', trigger: 'blur' }
          ],
          orderSn: [
            { required: true, message: '订单号不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: 'create_time不能为空', trigger: 'blur' }
          ],
          userUsername: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          totalAmount: [
            { required: true, message: '订单总额不能为空', trigger: 'blur' }
          ],
          payAmount: [
            { required: true, message: '应付总额不能为空', trigger: 'blur' }
          ],
          payType: [
            { required: true, message: '支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】不能为空', trigger: 'blur' }
          ],
          sourceType: [
            { required: true, message: '订单来源[0->PC订单；1->app订单]不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '订单状态【0->待付款；1->待接单；2->已接单；3->已完成；4->已关闭；5->无效订单】不能为空', trigger: 'blur' }
          ],
          userName: [
            { required: true, message: '用户姓名不能为空', trigger: 'blur' }
          ],
          userPhone: [
            { required: true, message: '用户电话不能为空', trigger: 'blur' }
          ],
          userProvince: [
            { required: true, message: '省份/直辖市不能为空', trigger: 'blur' }
          ],
          userCity: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          userRegion: [
            { required: true, message: '区不能为空', trigger: 'blur' }
          ],
          userDetailAddress: [
            { required: true, message: '详细地址不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '订单备注不能为空', trigger: 'blur' }
          ],
          deleteStatus: [
            { required: true, message: '删除状态【0->未删除；1->已删除】不能为空', trigger: 'blur' }
          ],
          paymentTime: [
            { required: true, message: '支付时间不能为空', trigger: 'blur' }
          ],
          deliveryTime: [
            { required: true, message: '接单时间不能为空', trigger: 'blur' }
          ],
          finishTime: [
            { required: true, message: '结单时间不能为空', trigger: 'blur' }
          ],
          commentTime: [
            { required: true, message: '评价时间不能为空', trigger: 'blur' }
          ],
          modifyTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/order/order/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberId = data.order.memberId
                this.dataForm.orderSn = data.order.orderSn
                this.dataForm.createTime = data.order.createTime
                this.dataForm.userUsername = data.order.userUsername
                this.dataForm.totalAmount = data.order.totalAmount
                this.dataForm.payAmount = data.order.payAmount
                this.dataForm.payType = data.order.payType
                this.dataForm.sourceType = data.order.sourceType
                this.dataForm.status = data.order.status
                this.dataForm.userName = data.order.userName
                this.dataForm.userPhone = data.order.userPhone
                this.dataForm.userProvince = data.order.userProvince
                this.dataForm.userCity = data.order.userCity
                this.dataForm.userRegion = data.order.userRegion
                this.dataForm.userDetailAddress = data.order.userDetailAddress
                this.dataForm.note = data.order.note
                this.dataForm.deleteStatus = data.order.deleteStatus
                this.dataForm.paymentTime = data.order.paymentTime
                this.dataForm.deliveryTime = data.order.deliveryTime
                this.dataForm.finishTime = data.order.finishTime
                this.dataForm.commentTime = data.order.commentTime
                this.dataForm.modifyTime = data.order.modifyTime
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
              url: this.$http.adornUrl(`/order/order/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memberId': this.dataForm.memberId,
                'orderSn': this.dataForm.orderSn,
                'createTime': this.dataForm.createTime,
                'userUsername': this.dataForm.userUsername,
                'totalAmount': this.dataForm.totalAmount,
                'payAmount': this.dataForm.payAmount,
                'payType': this.dataForm.payType,
                'sourceType': this.dataForm.sourceType,
                'status': this.dataForm.status,
                'userName': this.dataForm.userName,
                'userPhone': this.dataForm.userPhone,
                'userProvince': this.dataForm.userProvince,
                'userCity': this.dataForm.userCity,
                'userRegion': this.dataForm.userRegion,
                'userDetailAddress': this.dataForm.userDetailAddress,
                'note': this.dataForm.note,
                'deleteStatus': this.dataForm.deleteStatus,
                'paymentTime': this.dataForm.paymentTime,
                'deliveryTime': this.dataForm.deliveryTime,
                'finishTime': this.dataForm.finishTime,
                'commentTime': this.dataForm.commentTime,
                'modifyTime': this.dataForm.modifyTime
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
