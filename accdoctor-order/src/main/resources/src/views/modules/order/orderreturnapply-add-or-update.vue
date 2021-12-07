<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="order_id" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="order_id"></el-input>
    </el-form-item>
    <el-form-item label="fellow_id" prop="fellowId">
      <el-input v-model="dataForm.fellowId" placeholder="fellow_id"></el-input>
    </el-form-item>
    <el-form-item label="订单编号" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder="订单编号"></el-input>
    </el-form-item>
    <el-form-item label="申请时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="申请时间"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="userUsername">
      <el-input v-model="dataForm.userUsername" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="退款金额" prop="returnAmount">
      <el-input v-model="dataForm.returnAmount" placeholder="退款金额"></el-input>
    </el-form-item>
    <el-form-item label="退款人姓名" prop="returnName">
      <el-input v-model="dataForm.returnName" placeholder="退款人姓名"></el-input>
    </el-form-item>
    <el-form-item label="退款人电话" prop="returnPhone">
      <el-input v-model="dataForm.returnPhone" placeholder="退款人电话"></el-input>
    </el-form-item>
    <el-form-item label="申请状态[0->待处理；1->退款中；2->已完成；3->已拒绝]" prop="status">
      <el-input v-model="dataForm.status" placeholder="申请状态[0->待处理；1->退款中；2->已完成；3->已拒绝]"></el-input>
    </el-form-item>
    <el-form-item label="处理时间" prop="handleTime">
      <el-input v-model="dataForm.handleTime" placeholder="处理时间"></el-input>
    </el-form-item>
    <el-form-item label="原因" prop="reason">
      <el-input v-model="dataForm.reason" placeholder="原因"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="凭证图片，以逗号隔开" prop="descPics">
      <el-input v-model="dataForm.descPics" placeholder="凭证图片，以逗号隔开"></el-input>
    </el-form-item>
    <el-form-item label="处理备注" prop="handleNote">
      <el-input v-model="dataForm.handleNote" placeholder="处理备注"></el-input>
    </el-form-item>
    <el-form-item label="处理人员" prop="handleMan">
      <el-input v-model="dataForm.handleMan" placeholder="处理人员"></el-input>
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
          orderId: '',
          fellowId: '',
          orderSn: '',
          createTime: '',
          userUsername: '',
          returnAmount: '',
          returnName: '',
          returnPhone: '',
          status: '',
          handleTime: '',
          reason: '',
          description: '',
          descPics: '',
          handleNote: '',
          handleMan: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: 'order_id不能为空', trigger: 'blur' }
          ],
          fellowId: [
            { required: true, message: 'fellow_id不能为空', trigger: 'blur' }
          ],
          orderSn: [
            { required: true, message: '订单编号不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '申请时间不能为空', trigger: 'blur' }
          ],
          userUsername: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          returnAmount: [
            { required: true, message: '退款金额不能为空', trigger: 'blur' }
          ],
          returnName: [
            { required: true, message: '退款人姓名不能为空', trigger: 'blur' }
          ],
          returnPhone: [
            { required: true, message: '退款人电话不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '申请状态[0->待处理；1->退款中；2->已完成；3->已拒绝]不能为空', trigger: 'blur' }
          ],
          handleTime: [
            { required: true, message: '处理时间不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '原因不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          descPics: [
            { required: true, message: '凭证图片，以逗号隔开不能为空', trigger: 'blur' }
          ],
          handleNote: [
            { required: true, message: '处理备注不能为空', trigger: 'blur' }
          ],
          handleMan: [
            { required: true, message: '处理人员不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/order/orderreturnapply/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.orderReturnApply.orderId
                this.dataForm.fellowId = data.orderReturnApply.fellowId
                this.dataForm.orderSn = data.orderReturnApply.orderSn
                this.dataForm.createTime = data.orderReturnApply.createTime
                this.dataForm.userUsername = data.orderReturnApply.userUsername
                this.dataForm.returnAmount = data.orderReturnApply.returnAmount
                this.dataForm.returnName = data.orderReturnApply.returnName
                this.dataForm.returnPhone = data.orderReturnApply.returnPhone
                this.dataForm.status = data.orderReturnApply.status
                this.dataForm.handleTime = data.orderReturnApply.handleTime
                this.dataForm.reason = data.orderReturnApply.reason
                this.dataForm.description = data.orderReturnApply.description
                this.dataForm.descPics = data.orderReturnApply.descPics
                this.dataForm.handleNote = data.orderReturnApply.handleNote
                this.dataForm.handleMan = data.orderReturnApply.handleMan
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
              url: this.$http.adornUrl(`/order/orderreturnapply/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'fellowId': this.dataForm.fellowId,
                'orderSn': this.dataForm.orderSn,
                'createTime': this.dataForm.createTime,
                'userUsername': this.dataForm.userUsername,
                'returnAmount': this.dataForm.returnAmount,
                'returnName': this.dataForm.returnName,
                'returnPhone': this.dataForm.returnPhone,
                'status': this.dataForm.status,
                'handleTime': this.dataForm.handleTime,
                'reason': this.dataForm.reason,
                'description': this.dataForm.description,
                'descPics': this.dataForm.descPics,
                'handleNote': this.dataForm.handleNote,
                'handleMan': this.dataForm.handleMan
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
